/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.psj.common.avro.avpr;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public interface Calculator {
  public static final org.apache.avro.Protocol PROTOCOL = org.apache.avro.Protocol.parse("{\"protocol\":\"Calculator\",\"namespace\":\"com.psj.common.avro.avpr\",\"types\":[],\"messages\":{\"add\":{\"request\":[{\"name\":\"x\",\"type\":\"double\"},{\"name\":\"y\",\"type\":\"double\"}],\"response\":\"double\"},\"subtract\":{\"request\":[{\"name\":\"x\",\"type\":\"double\"},{\"name\":\"y\",\"type\":\"double\"}],\"response\":\"double\"}}}");
  /**
   */
  double add(double x, double y) throws org.apache.avro.AvroRemoteException;
  /**
   */
  double subtract(double x, double y) throws org.apache.avro.AvroRemoteException;

  @SuppressWarnings("all")
  public interface Callback extends Calculator {
    public static final org.apache.avro.Protocol PROTOCOL = com.psj.common.avro.avpr.Calculator.PROTOCOL;
    /**
     * @throws java.io.IOException The async call could not be completed.
     */
    void add(double x, double y, org.apache.avro.ipc.Callback<java.lang.Double> callback) throws java.io.IOException;
    /**
     * @throws java.io.IOException The async call could not be completed.
     */
    void subtract(double x, double y, org.apache.avro.ipc.Callback<java.lang.Double> callback) throws java.io.IOException;
  }
}