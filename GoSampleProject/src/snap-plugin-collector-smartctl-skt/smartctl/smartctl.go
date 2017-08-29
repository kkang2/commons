package smartctl

import (
	"github.com/intelsdi-x/snap-plugin-lib-go/v1/plugin"
	"github.com/Sirupsen/logrus"
	"os"
	"strings"
	_ "fmt"
)

type SmartctlCollector struct {
	metricMap map[string]string
}

var metricPrefixs = []string{"skt", "custom", "disk"}
var logger = logrus.New()

func init() {
	logger.Out = os.Stdout
}

func New() (*SmartctlCollector) {
	return &SmartctlCollector{metricMap: map[string]string{"test":"testData"}}
}

/* CollectMetrics collects metrics for testing.
	CollectMetrics() will be called by Snap when a task that collects one of the metrics returned from this plugins
	GetMetricTypes() is started. The input will include a slice of all the metric types being collected.
	The output is the collected metrics as plugin.Metric and an error.
*/
func (sc *SmartctlCollector) CollectMetrics(mts []plugin.Metric) ([]plugin.Metric, error) {
	logger.Info("CollectMetrics Start!!")
	
	metrics := []plugin.Metric{}
	devInfo := GetDeviceInfo()
	
	for _, info := range devInfo {
		for i, smart := range info.Smart {
			if i >= info.NumSmart {
				break;
			}
			
			namespace := append(metricPrefixs, strings.Split(info.Name[1:], "/")...)
			namespace = append(namespace, strings.ToLower(smart.Key))
			
			metrics = append(metrics, 
				plugin.Metric{
						Namespace: plugin.NewNamespace(namespace...),
						Data: strings.TrimSpace(smart.Value),
			})
		}
	}
	
	metrics = append(metrics,
				plugin.Metric{
						Namespace: plugin.NewNamespace("psj", "name", "dev"),
						Data: "you so handsome",
			})
	
	logger.Info("CollectMetrics End!!")
	
	return metrics, nil
}

/*
	GetMetricTypes returns metric types for testing.
	GetMetricTypes() will be called when your plugin is loaded in order to populate the metric catalog(where snaps stores all
	available metrics).
	Config info is passed in. This config information would come from global config snap settings.
	The metrics returned will be advertised to users who list all the metrics and will become targetable by tasks.
*/
func (sc *SmartctlCollector) GetMetricTypes(cfg plugin.Config) ([]plugin.Metric, error) {
	logger.Info("GetMetricTypes Start!!")
	
	metrics := []plugin.Metric{}
	devInfo := GetDeviceInfo()
	
	for _, info := range devInfo {
		for i, smart := range info.Smart {
			if i >= info.NumSmart {
				break;
			}
			
			namespace := append(metricPrefixs, strings.Split(info.Name[1:], "/")...)
			namespace = append(namespace, strings.ToLower(smart.Key))
			
			logger.Info(namespace)
			
			metrics = append(metrics,
				plugin.Metric{
					Namespace: plugin.NewNamespace(namespace...),
					Description: strings.Join(namespace, "/"),
			})
		}
	}
	
	logger.Info("GetMetricTypes End!!")
	
	return metrics, nil
}

/*
	GetConfigPolicy() returns the configPolicy for your plugin.
	A config policy is how users can provide configuration info to
	plugin. Here you define what sorts of config info your plugin
	needs and/or requires.
*/
func (sc *SmartctlCollector) GetConfigPolicy() (plugin.ConfigPolicy, error) {
	logger.Info("GetConfigPolicy Start!!")
	
	policy := plugin.NewConfigPolicy()

	logger.Info("GetConfigPolicy End!!")
	
	return *policy, nil
}