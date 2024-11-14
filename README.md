[csp]
https://dpwp.samsungds.net
https://spwp.samsungds.net
https://pwp.samsungds.net

[젠킨스]
http://10.166.250.80:8081
developer/developer
admin/Metanet12!@

[adfs]
dssp18482.id/sung0070@@
dssp18482.id/tka123tjd!! <- 테스트 계정

[Single Sign On] -> https://sso.sec.samsung.net
dssp18482.id/4yD17N6j

[knox]
개발 -> dssp18482.id/sung0070@@
운영 -> dssp18482.id/park0070@@

[hiware]
sung0070@@

[넥서스] pwp/Metanet12!@
http://nexus.adpaas.cloud.samsungds.net/#browse/browse:pwp

[각종 사이트]
https://portal.swp.paas.cloud.samsungds.net/home <- voc 등록 사이트
http://itplatform.paas.cloud.samsungds.net/ <- 유저 서비스 포털
https://portal.dscloud.samsungds.net/ <- DS CLOUD 자원관리(LB, Object Storage)
https://www.tableau.com/ko-kr/developer/tools <- tableau 개발자 사이트
https://metanet.dkyobobook.co.kr/main.ink mallakkang@metanet.co.kr/2415039
https://jira.samsungds.net/ <- DS Jira 사이트
https://confluence.samsungds.net/ - 삼성 컨플루언스 사이트
https://secpartner.samsung.net/loginapp/login -> knox Potal
http://techdocs.emro.co.kr/pages/viewpage.action?pageId=80380813 <- 엠로 기술사이트
http://alm.emro.co.kr/servicedesk/customer/portals <- 엠로 질문사이트
https://github.samsungds.net/ <- 깃허브 사이트
https://devops.samsungds.net/ <- P-DEP
https://confluence.samsungds.net/pages/releaseview.action?pageId=1446025929 <- P-DEP관련

[스크립트]
- stop
# Find the PID of the process using port 1234
#PID=$(cat pwp-apigw-ssp.pid)

var=$(ps -ef | grep java | grep pwp-apigw | grep -v 'grep' |grep -v $0)
PID=$(echo ${var} | cut -d " " -f2)

# If PID exists, kill it
if [ ! -z "$PID" ]; then
  echo "> 현재 구동중인apigw 애플리케이션이 있습니다. 해당 pid를 삭제합니다"
  kill -9 $PID
fi
- start
# Elastic APM
PRODUCT_GROUP_ID="purchasewp"
PRODUCT_ID="pwp-csp-prod"
PRODUCT_PHASE="prod"
APM_AGENT_PATH="/appdata/appuser"
APPLICATION_PACKAGE="net.samsungds.pwp.common"
ENV="prd"

java -Xms2048m -Xmx4096m  -javaagent:${APM_AGENT_PATH}/apm-agent.jar -Delastic.apm.server_url=https://apm.elastic.samsungds.net:8200 -Delastic.apm.service_name=${PRODUCT_GROUP_ID}--${PRODUCT_ID} -Delastic.apm.environment=${PRODUCT_PHASE} -Delastic.apm.global_labels=productgroupid=${PRODUCT_GROUP_ID},productid=${PRODUCT_ID} -Delastic.apm.secret_token=NmL5qhSBlPA2huTAmT -Delastic.apm.verify_server_cert=false -Delastic.apm.application_packages=${APPLICATION_PACKAGE} -jar -Dspring.profiles.active=${ENV} pwp-csp-0.0.1.war
nohup java -Xms2048m -Xmx2048m -jar -Dspring.profiles.active="prd" -DcspNm=pwp01 pwp-apigw-ssp-0.0.1.jar 1>/dev/null 2>&1 &

[젠킨스]
- CSP
pipeline{

    environment {
        TARGET_ID = "appuser"
        TARGET_IP_1 = "10.172.98.134"
        TARGET_IP_2 = "10.172.98.135"
        TARGET_HOST_1 = "${TARGET_ID}@${TARGET_IP_1}"
        TARGET_HOST_2 = "${TARGET_ID}@${TARGET_IP_2}"
        APP_NAME = "pwp-csp"
        ENV = "prd"
        GIT_CREDENTIAL_ID = "jenkins-git-dscwp"
        BRANCH = "master"      
        
        NEXUS_HOST = "http://nexus.adpaas.cloud.samsungds.net/repository/pwp/net/samsungds/pwp/common/pwp-csp/0.0.1"
        NEXUS_FILE = "pwp-csp-0.0.1"
        NEXUS_ID ="pwp"
        NEXUS_PW ="Metanet12!@"
    }
    
    agent any
    options {
        timestamps()
    }    
    stages{
        // stage('Setup parameters') {
        //     steps {
        //         script { 
        //             properties([
        //                 parameters([
        //                     string(
        //                         defaultValue: '1.0', 
        //                         name: 'IMAGE_VERSION', 
        //                         trim: true
        //                     )
        //                 ])
        //             ])
        //         }
        //     }
        // }
        stage('Git Clone'){
            steps{
                cleanWs()
                
                echo 'Git Clone'
                git branch: "${BRANCH}", credentialsId: "${GIT_CREDENTIAL_ID}", url: "https://github.samsungds.net/PurchaseWP/${APP_NAME}.git"
            }
        }
        
        stage('Build'){
            steps{
                echo 'Maven Build'
                // sh '/home/jenkins/apache-maven-3.8.8/bin/mvn -Dmaven.test.failure.ignore=true -N -f pom.xml -s /home/jenkins/apache-maven-3.8.8/conf/settings.xml clean package -e'
                sh """
                    cp ./src/main/resources/smartsuite/properties/profile/${ENV}/smartsuite.properties ./src/main/resources/smartsuite/properties/smartsuite.properties
                    cp ./src/main/resources/smartsuite/properties/profile/${ENV}/ehcache1.xml ./src/main/resources/ehcache.xml

                    cp ./src/main/resources/static/bower_components/sc-grid/resources/smartdatagrid/smart-datagrid-lic-${ENV}.js ./src/main/resources/static/bower_components/sc-grid/resources/smartdatagrid/smart-datagrid-lic.js
                    /home/jenkins/apache-maven-3.8.8/bin/mvn -Dmaven.test.failure.ignore=true -N -f pom.xml -s /home/jenkins/apache-maven-3.8.8/conf/settings.xml clean package -e
                    
                    curl -v -u ${NEXUS_ID}:${NEXUS_PW} --upload-file target/${NEXUS_FILE}.war ${NEXUS_HOST}/${NEXUS_FILE}-${ENV}-${BUILD_ID}.war
                """                                
            }
        }
        
        stage('Deploy VM 1'){
            steps{
                echo 'Deploy VM 1'
                sh """
                    scp ./src/main/resources/smartsuite/properties/profile/${ENV}/conf/redis-data-cache.properties $TARGET_HOST_1:/appdata/appuser/tomcat/conf/redis-data-cache.properties

                    ssh -o StrictHostKeyChecking=no $TARGET_HOST_1 /appdata/$TARGET_ID/stop_service.sh
                    scp ./target/pwp-csp-0.0.1.war $TARGET_HOST_1:/appdata/$TARGET_ID
                    ssh -o StrictHostKeyChecking=no $TARGET_HOST_1 nohup /appdata/$TARGET_ID/start_service.sh > /dev/null 2>&1 &

                """ 
            }
        }
        
        stage('Deploy VM 2'){
            steps{
                echo 'Deploy VM 2'
                sh """
                    mkdir -p ./target/WEB-INF/classes/smartsuite/properties
                    cp ./src/main/resources/smartsuite/properties/profile/${ENV}/smartsuite_extra.properties ./target/WEB-INF/classes/smartsuite/properties/smartsuite.properties
                    cp ./src/main/resources/smartsuite/properties/profile/${ENV}/ehcache2.xml ./target/WEB-INF/classes/ehcache.xml
                    cd target
                    jar uvf pwp-csp-0.0.1.war WEB-INF/classes/smartsuite/properties/smartsuite.properties WEB-INF/classes/ehcache.xml
                    cd ../
                    
                    scp ./src/main/resources/smartsuite/properties/profile/${ENV}/conf/redis-data-cache.properties $TARGET_HOST_2:/appdata/appuser/tomcat/conf/redis-data-cache.properties

                    ssh -o StrictHostKeyChecking=no $TARGET_HOST_2 /appdata/$TARGET_ID/stop_service.sh
                    scp ./target/pwp-csp-0.0.1.war $TARGET_HOST_2:/appdata/$TARGET_ID
                    ssh -o StrictHostKeyChecking=no $TARGET_HOST_2 nohup /appdata/$TARGET_ID/start_service.sh > /dev/null 2>&1 &
                """
            }
        }
    }
}


