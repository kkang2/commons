/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.psj.common.avro.avdl;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class SearchResult extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 5221495639619379074L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"SearchResult\",\"namespace\":\"com.psj.common.avro.avdl\",\"fields\":[{\"name\":\"pageNo\",\"type\":\"int\"},{\"name\":\"pageSize\",\"type\":\"int\"},{\"name\":\"pageCount\",\"type\":\"int\"},{\"name\":\"totalItemCount\",\"type\":\"int\"},{\"name\":\"entities\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Entity\",\"fields\":[{\"name\":\"rowId\",\"type\":\"string\"},{\"name\":\"createdAt\",\"type\":\"string\"},{\"name\":\"text\",\"type\":\"string\"},{\"name\":\"attrs\",\"type\":{\"type\":\"map\",\"values\":\"string\"}}]}}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<SearchResult> ENCODER =
      new BinaryMessageEncoder<SearchResult>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<SearchResult> DECODER =
      new BinaryMessageDecoder<SearchResult>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<SearchResult> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<SearchResult> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<SearchResult>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this SearchResult to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a SearchResult from a ByteBuffer. */
  public static SearchResult fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public int pageNo;
  @Deprecated public int pageSize;
  @Deprecated public int pageCount;
  @Deprecated public int totalItemCount;
  @Deprecated public java.util.List<com.psj.common.avro.avdl.Entity> entities;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public SearchResult() {}

  /**
   * All-args constructor.
   * @param pageNo The new value for pageNo
   * @param pageSize The new value for pageSize
   * @param pageCount The new value for pageCount
   * @param totalItemCount The new value for totalItemCount
   * @param entities The new value for entities
   */
  public SearchResult(java.lang.Integer pageNo, java.lang.Integer pageSize, java.lang.Integer pageCount, java.lang.Integer totalItemCount, java.util.List<com.psj.common.avro.avdl.Entity> entities) {
    this.pageNo = pageNo;
    this.pageSize = pageSize;
    this.pageCount = pageCount;
    this.totalItemCount = totalItemCount;
    this.entities = entities;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return pageNo;
    case 1: return pageSize;
    case 2: return pageCount;
    case 3: return totalItemCount;
    case 4: return entities;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: pageNo = (java.lang.Integer)value$; break;
    case 1: pageSize = (java.lang.Integer)value$; break;
    case 2: pageCount = (java.lang.Integer)value$; break;
    case 3: totalItemCount = (java.lang.Integer)value$; break;
    case 4: entities = (java.util.List<com.psj.common.avro.avdl.Entity>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'pageNo' field.
   * @return The value of the 'pageNo' field.
   */
  public java.lang.Integer getPageNo() {
    return pageNo;
  }

  /**
   * Sets the value of the 'pageNo' field.
   * @param value the value to set.
   */
  public void setPageNo(java.lang.Integer value) {
    this.pageNo = value;
  }

  /**
   * Gets the value of the 'pageSize' field.
   * @return The value of the 'pageSize' field.
   */
  public java.lang.Integer getPageSize() {
    return pageSize;
  }

  /**
   * Sets the value of the 'pageSize' field.
   * @param value the value to set.
   */
  public void setPageSize(java.lang.Integer value) {
    this.pageSize = value;
  }

  /**
   * Gets the value of the 'pageCount' field.
   * @return The value of the 'pageCount' field.
   */
  public java.lang.Integer getPageCount() {
    return pageCount;
  }

  /**
   * Sets the value of the 'pageCount' field.
   * @param value the value to set.
   */
  public void setPageCount(java.lang.Integer value) {
    this.pageCount = value;
  }

  /**
   * Gets the value of the 'totalItemCount' field.
   * @return The value of the 'totalItemCount' field.
   */
  public java.lang.Integer getTotalItemCount() {
    return totalItemCount;
  }

  /**
   * Sets the value of the 'totalItemCount' field.
   * @param value the value to set.
   */
  public void setTotalItemCount(java.lang.Integer value) {
    this.totalItemCount = value;
  }

  /**
   * Gets the value of the 'entities' field.
   * @return The value of the 'entities' field.
   */
  public java.util.List<com.psj.common.avro.avdl.Entity> getEntities() {
    return entities;
  }

  /**
   * Sets the value of the 'entities' field.
   * @param value the value to set.
   */
  public void setEntities(java.util.List<com.psj.common.avro.avdl.Entity> value) {
    this.entities = value;
  }

  /**
   * Creates a new SearchResult RecordBuilder.
   * @return A new SearchResult RecordBuilder
   */
  public static com.psj.common.avro.avdl.SearchResult.Builder newBuilder() {
    return new com.psj.common.avro.avdl.SearchResult.Builder();
  }

  /**
   * Creates a new SearchResult RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new SearchResult RecordBuilder
   */
  public static com.psj.common.avro.avdl.SearchResult.Builder newBuilder(com.psj.common.avro.avdl.SearchResult.Builder other) {
    return new com.psj.common.avro.avdl.SearchResult.Builder(other);
  }

  /**
   * Creates a new SearchResult RecordBuilder by copying an existing SearchResult instance.
   * @param other The existing instance to copy.
   * @return A new SearchResult RecordBuilder
   */
  public static com.psj.common.avro.avdl.SearchResult.Builder newBuilder(com.psj.common.avro.avdl.SearchResult other) {
    return new com.psj.common.avro.avdl.SearchResult.Builder(other);
  }

  /**
   * RecordBuilder for SearchResult instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<SearchResult>
    implements org.apache.avro.data.RecordBuilder<SearchResult> {

    private int pageNo;
    private int pageSize;
    private int pageCount;
    private int totalItemCount;
    private java.util.List<com.psj.common.avro.avdl.Entity> entities;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.psj.common.avro.avdl.SearchResult.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.pageNo)) {
        this.pageNo = data().deepCopy(fields()[0].schema(), other.pageNo);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.pageSize)) {
        this.pageSize = data().deepCopy(fields()[1].schema(), other.pageSize);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.pageCount)) {
        this.pageCount = data().deepCopy(fields()[2].schema(), other.pageCount);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.totalItemCount)) {
        this.totalItemCount = data().deepCopy(fields()[3].schema(), other.totalItemCount);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.entities)) {
        this.entities = data().deepCopy(fields()[4].schema(), other.entities);
        fieldSetFlags()[4] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing SearchResult instance
     * @param other The existing instance to copy.
     */
    private Builder(com.psj.common.avro.avdl.SearchResult other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.pageNo)) {
        this.pageNo = data().deepCopy(fields()[0].schema(), other.pageNo);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.pageSize)) {
        this.pageSize = data().deepCopy(fields()[1].schema(), other.pageSize);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.pageCount)) {
        this.pageCount = data().deepCopy(fields()[2].schema(), other.pageCount);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.totalItemCount)) {
        this.totalItemCount = data().deepCopy(fields()[3].schema(), other.totalItemCount);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.entities)) {
        this.entities = data().deepCopy(fields()[4].schema(), other.entities);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'pageNo' field.
      * @return The value.
      */
    public java.lang.Integer getPageNo() {
      return pageNo;
    }

    /**
      * Sets the value of the 'pageNo' field.
      * @param value The value of 'pageNo'.
      * @return This builder.
      */
    public com.psj.common.avro.avdl.SearchResult.Builder setPageNo(int value) {
      validate(fields()[0], value);
      this.pageNo = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'pageNo' field has been set.
      * @return True if the 'pageNo' field has been set, false otherwise.
      */
    public boolean hasPageNo() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'pageNo' field.
      * @return This builder.
      */
    public com.psj.common.avro.avdl.SearchResult.Builder clearPageNo() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'pageSize' field.
      * @return The value.
      */
    public java.lang.Integer getPageSize() {
      return pageSize;
    }

    /**
      * Sets the value of the 'pageSize' field.
      * @param value The value of 'pageSize'.
      * @return This builder.
      */
    public com.psj.common.avro.avdl.SearchResult.Builder setPageSize(int value) {
      validate(fields()[1], value);
      this.pageSize = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'pageSize' field has been set.
      * @return True if the 'pageSize' field has been set, false otherwise.
      */
    public boolean hasPageSize() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'pageSize' field.
      * @return This builder.
      */
    public com.psj.common.avro.avdl.SearchResult.Builder clearPageSize() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'pageCount' field.
      * @return The value.
      */
    public java.lang.Integer getPageCount() {
      return pageCount;
    }

    /**
      * Sets the value of the 'pageCount' field.
      * @param value The value of 'pageCount'.
      * @return This builder.
      */
    public com.psj.common.avro.avdl.SearchResult.Builder setPageCount(int value) {
      validate(fields()[2], value);
      this.pageCount = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'pageCount' field has been set.
      * @return True if the 'pageCount' field has been set, false otherwise.
      */
    public boolean hasPageCount() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'pageCount' field.
      * @return This builder.
      */
    public com.psj.common.avro.avdl.SearchResult.Builder clearPageCount() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'totalItemCount' field.
      * @return The value.
      */
    public java.lang.Integer getTotalItemCount() {
      return totalItemCount;
    }

    /**
      * Sets the value of the 'totalItemCount' field.
      * @param value The value of 'totalItemCount'.
      * @return This builder.
      */
    public com.psj.common.avro.avdl.SearchResult.Builder setTotalItemCount(int value) {
      validate(fields()[3], value);
      this.totalItemCount = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'totalItemCount' field has been set.
      * @return True if the 'totalItemCount' field has been set, false otherwise.
      */
    public boolean hasTotalItemCount() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'totalItemCount' field.
      * @return This builder.
      */
    public com.psj.common.avro.avdl.SearchResult.Builder clearTotalItemCount() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'entities' field.
      * @return The value.
      */
    public java.util.List<com.psj.common.avro.avdl.Entity> getEntities() {
      return entities;
    }

    /**
      * Sets the value of the 'entities' field.
      * @param value The value of 'entities'.
      * @return This builder.
      */
    public com.psj.common.avro.avdl.SearchResult.Builder setEntities(java.util.List<com.psj.common.avro.avdl.Entity> value) {
      validate(fields()[4], value);
      this.entities = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'entities' field has been set.
      * @return True if the 'entities' field has been set, false otherwise.
      */
    public boolean hasEntities() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'entities' field.
      * @return This builder.
      */
    public com.psj.common.avro.avdl.SearchResult.Builder clearEntities() {
      entities = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public SearchResult build() {
      try {
        SearchResult record = new SearchResult();
        record.pageNo = fieldSetFlags()[0] ? this.pageNo : (java.lang.Integer) defaultValue(fields()[0]);
        record.pageSize = fieldSetFlags()[1] ? this.pageSize : (java.lang.Integer) defaultValue(fields()[1]);
        record.pageCount = fieldSetFlags()[2] ? this.pageCount : (java.lang.Integer) defaultValue(fields()[2]);
        record.totalItemCount = fieldSetFlags()[3] ? this.totalItemCount : (java.lang.Integer) defaultValue(fields()[3]);
        record.entities = fieldSetFlags()[4] ? this.entities : (java.util.List<com.psj.common.avro.avdl.Entity>) defaultValue(fields()[4]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<SearchResult>
    WRITER$ = (org.apache.avro.io.DatumWriter<SearchResult>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<SearchResult>
    READER$ = (org.apache.avro.io.DatumReader<SearchResult>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
