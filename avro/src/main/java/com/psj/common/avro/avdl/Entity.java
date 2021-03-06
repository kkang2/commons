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
public class Entity extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 2566542298497925506L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Entity\",\"namespace\":\"com.psj.common.avro.avdl\",\"fields\":[{\"name\":\"rowId\",\"type\":\"string\"},{\"name\":\"createdAt\",\"type\":\"string\"},{\"name\":\"text\",\"type\":\"string\"},{\"name\":\"attrs\",\"type\":{\"type\":\"map\",\"values\":\"string\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Entity> ENCODER =
      new BinaryMessageEncoder<Entity>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Entity> DECODER =
      new BinaryMessageDecoder<Entity>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Entity> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Entity> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Entity>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Entity to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Entity from a ByteBuffer. */
  public static Entity fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence rowId;
  @Deprecated public java.lang.CharSequence createdAt;
  @Deprecated public java.lang.CharSequence text;
  @Deprecated public java.util.Map<java.lang.CharSequence,java.lang.CharSequence> attrs;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Entity() {}

  /**
   * All-args constructor.
   * @param rowId The new value for rowId
   * @param createdAt The new value for createdAt
   * @param text The new value for text
   * @param attrs The new value for attrs
   */
  public Entity(java.lang.CharSequence rowId, java.lang.CharSequence createdAt, java.lang.CharSequence text, java.util.Map<java.lang.CharSequence,java.lang.CharSequence> attrs) {
    this.rowId = rowId;
    this.createdAt = createdAt;
    this.text = text;
    this.attrs = attrs;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return rowId;
    case 1: return createdAt;
    case 2: return text;
    case 3: return attrs;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: rowId = (java.lang.CharSequence)value$; break;
    case 1: createdAt = (java.lang.CharSequence)value$; break;
    case 2: text = (java.lang.CharSequence)value$; break;
    case 3: attrs = (java.util.Map<java.lang.CharSequence,java.lang.CharSequence>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'rowId' field.
   * @return The value of the 'rowId' field.
   */
  public java.lang.CharSequence getRowId() {
    return rowId;
  }

  /**
   * Sets the value of the 'rowId' field.
   * @param value the value to set.
   */
  public void setRowId(java.lang.CharSequence value) {
    this.rowId = value;
  }

  /**
   * Gets the value of the 'createdAt' field.
   * @return The value of the 'createdAt' field.
   */
  public java.lang.CharSequence getCreatedAt() {
    return createdAt;
  }

  /**
   * Sets the value of the 'createdAt' field.
   * @param value the value to set.
   */
  public void setCreatedAt(java.lang.CharSequence value) {
    this.createdAt = value;
  }

  /**
   * Gets the value of the 'text' field.
   * @return The value of the 'text' field.
   */
  public java.lang.CharSequence getText() {
    return text;
  }

  /**
   * Sets the value of the 'text' field.
   * @param value the value to set.
   */
  public void setText(java.lang.CharSequence value) {
    this.text = value;
  }

  /**
   * Gets the value of the 'attrs' field.
   * @return The value of the 'attrs' field.
   */
  public java.util.Map<java.lang.CharSequence,java.lang.CharSequence> getAttrs() {
    return attrs;
  }

  /**
   * Sets the value of the 'attrs' field.
   * @param value the value to set.
   */
  public void setAttrs(java.util.Map<java.lang.CharSequence,java.lang.CharSequence> value) {
    this.attrs = value;
  }

  /**
   * Creates a new Entity RecordBuilder.
   * @return A new Entity RecordBuilder
   */
  public static com.psj.common.avro.avdl.Entity.Builder newBuilder() {
    return new com.psj.common.avro.avdl.Entity.Builder();
  }

  /**
   * Creates a new Entity RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Entity RecordBuilder
   */
  public static com.psj.common.avro.avdl.Entity.Builder newBuilder(com.psj.common.avro.avdl.Entity.Builder other) {
    return new com.psj.common.avro.avdl.Entity.Builder(other);
  }

  /**
   * Creates a new Entity RecordBuilder by copying an existing Entity instance.
   * @param other The existing instance to copy.
   * @return A new Entity RecordBuilder
   */
  public static com.psj.common.avro.avdl.Entity.Builder newBuilder(com.psj.common.avro.avdl.Entity other) {
    return new com.psj.common.avro.avdl.Entity.Builder(other);
  }

  /**
   * RecordBuilder for Entity instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Entity>
    implements org.apache.avro.data.RecordBuilder<Entity> {

    private java.lang.CharSequence rowId;
    private java.lang.CharSequence createdAt;
    private java.lang.CharSequence text;
    private java.util.Map<java.lang.CharSequence,java.lang.CharSequence> attrs;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.psj.common.avro.avdl.Entity.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.rowId)) {
        this.rowId = data().deepCopy(fields()[0].schema(), other.rowId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[1].schema(), other.createdAt);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.text)) {
        this.text = data().deepCopy(fields()[2].schema(), other.text);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.attrs)) {
        this.attrs = data().deepCopy(fields()[3].schema(), other.attrs);
        fieldSetFlags()[3] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Entity instance
     * @param other The existing instance to copy.
     */
    private Builder(com.psj.common.avro.avdl.Entity other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.rowId)) {
        this.rowId = data().deepCopy(fields()[0].schema(), other.rowId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[1].schema(), other.createdAt);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.text)) {
        this.text = data().deepCopy(fields()[2].schema(), other.text);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.attrs)) {
        this.attrs = data().deepCopy(fields()[3].schema(), other.attrs);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'rowId' field.
      * @return The value.
      */
    public java.lang.CharSequence getRowId() {
      return rowId;
    }

    /**
      * Sets the value of the 'rowId' field.
      * @param value The value of 'rowId'.
      * @return This builder.
      */
    public com.psj.common.avro.avdl.Entity.Builder setRowId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.rowId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'rowId' field has been set.
      * @return True if the 'rowId' field has been set, false otherwise.
      */
    public boolean hasRowId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'rowId' field.
      * @return This builder.
      */
    public com.psj.common.avro.avdl.Entity.Builder clearRowId() {
      rowId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'createdAt' field.
      * @return The value.
      */
    public java.lang.CharSequence getCreatedAt() {
      return createdAt;
    }

    /**
      * Sets the value of the 'createdAt' field.
      * @param value The value of 'createdAt'.
      * @return This builder.
      */
    public com.psj.common.avro.avdl.Entity.Builder setCreatedAt(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.createdAt = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'createdAt' field has been set.
      * @return True if the 'createdAt' field has been set, false otherwise.
      */
    public boolean hasCreatedAt() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'createdAt' field.
      * @return This builder.
      */
    public com.psj.common.avro.avdl.Entity.Builder clearCreatedAt() {
      createdAt = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'text' field.
      * @return The value.
      */
    public java.lang.CharSequence getText() {
      return text;
    }

    /**
      * Sets the value of the 'text' field.
      * @param value The value of 'text'.
      * @return This builder.
      */
    public com.psj.common.avro.avdl.Entity.Builder setText(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.text = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'text' field has been set.
      * @return True if the 'text' field has been set, false otherwise.
      */
    public boolean hasText() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'text' field.
      * @return This builder.
      */
    public com.psj.common.avro.avdl.Entity.Builder clearText() {
      text = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'attrs' field.
      * @return The value.
      */
    public java.util.Map<java.lang.CharSequence,java.lang.CharSequence> getAttrs() {
      return attrs;
    }

    /**
      * Sets the value of the 'attrs' field.
      * @param value The value of 'attrs'.
      * @return This builder.
      */
    public com.psj.common.avro.avdl.Entity.Builder setAttrs(java.util.Map<java.lang.CharSequence,java.lang.CharSequence> value) {
      validate(fields()[3], value);
      this.attrs = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'attrs' field has been set.
      * @return True if the 'attrs' field has been set, false otherwise.
      */
    public boolean hasAttrs() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'attrs' field.
      * @return This builder.
      */
    public com.psj.common.avro.avdl.Entity.Builder clearAttrs() {
      attrs = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Entity build() {
      try {
        Entity record = new Entity();
        record.rowId = fieldSetFlags()[0] ? this.rowId : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.createdAt = fieldSetFlags()[1] ? this.createdAt : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.text = fieldSetFlags()[2] ? this.text : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.attrs = fieldSetFlags()[3] ? this.attrs : (java.util.Map<java.lang.CharSequence,java.lang.CharSequence>) defaultValue(fields()[3]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Entity>
    WRITER$ = (org.apache.avro.io.DatumWriter<Entity>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Entity>
    READER$ = (org.apache.avro.io.DatumReader<Entity>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
