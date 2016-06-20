/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.market.observable;

import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.strata.basics.index.Index;
import com.opengamma.strata.data.FieldName;
import com.opengamma.strata.data.ObservableId;
import com.opengamma.strata.data.ObservableSource;

/**
 * An identifier used to access the current value of an index.
 * <p>
 * This identifier can also be used to access the historic time-series of values.
 */
@BeanDefinition(builderScope = "private")
public final class IndexQuoteId implements ObservableId, ImmutableBean, Serializable {

  /**
   * The index.
   */
  @PropertyDefinition(validate = "notNull")
  private final Index index;
  /**
   * The field name in the market data record that contains the market data item.
   * The most common field name is {@linkplain FieldName#MARKET_VALUE market value}.
   */
  @PropertyDefinition(validate = "notNull")
  private final FieldName fieldName;
  /**
   * The source of observable market data.
   */
  @PropertyDefinition(validate = "notNull", overrideGet = true)
  private final ObservableSource observableSource;

  //-------------------------------------------------------------------------
  /**
   * Obtains an instance used to obtain an observable value of the index.
   * <p>
   * The field name containing the data is {@link FieldName#MARKET_VALUE} and the market
   * data source is {@link ObservableSource#NONE}.
   *
   * @param index  the index
   * @return the identifier
   */
  public static IndexQuoteId of(Index index) {
    return new IndexQuoteId(index, FieldName.MARKET_VALUE, ObservableSource.NONE);
  }

  /**
   * Obtains an instance used to obtain an observable value of the index.
   * <p>
   * The market data source is {@link ObservableSource#NONE}.
   *
   * @param index  the index
   * @param fieldName  the name of the field in the market data record holding the data
   * @return the identifier
   */
  public static IndexQuoteId of(Index index, FieldName fieldName) {
    return new IndexQuoteId(index, fieldName, ObservableSource.NONE);
  }

  /**
   * Obtains an instance used to obtain an observable value of the index,
   * specifying the source of observable market data.
   *
   * @param index  the index
   * @param fieldName  the name of the field in the market data record holding the data
   * @param obsSource  the source of observable market data
   * @return the identifier
   */
  public static IndexQuoteId of(Index index, FieldName fieldName, ObservableSource obsSource) {
    return new IndexQuoteId(index, fieldName, obsSource);
  }

  //-------------------------------------------------------------------------
  @Override
  public IndexQuoteId withObservableSource(ObservableSource obsSource) {
    return new IndexQuoteId(index, fieldName, obsSource);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code IndexQuoteId}.
   * @return the meta-bean, not null
   */
  public static IndexQuoteId.Meta meta() {
    return IndexQuoteId.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(IndexQuoteId.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  private IndexQuoteId(
      Index index,
      FieldName fieldName,
      ObservableSource observableSource) {
    JodaBeanUtils.notNull(index, "index");
    JodaBeanUtils.notNull(fieldName, "fieldName");
    JodaBeanUtils.notNull(observableSource, "observableSource");
    this.index = index;
    this.fieldName = fieldName;
    this.observableSource = observableSource;
  }

  @Override
  public IndexQuoteId.Meta metaBean() {
    return IndexQuoteId.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the index.
   * @return the value of the property, not null
   */
  public Index getIndex() {
    return index;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the field name in the market data record that contains the market data item.
   * The most common field name is {@linkplain FieldName#MARKET_VALUE market value}.
   * @return the value of the property, not null
   */
  public FieldName getFieldName() {
    return fieldName;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the source of observable market data.
   * @return the value of the property, not null
   */
  @Override
  public ObservableSource getObservableSource() {
    return observableSource;
  }

  //-----------------------------------------------------------------------
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      IndexQuoteId other = (IndexQuoteId) obj;
      return JodaBeanUtils.equal(index, other.index) &&
          JodaBeanUtils.equal(fieldName, other.fieldName) &&
          JodaBeanUtils.equal(observableSource, other.observableSource);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(index);
    hash = hash * 31 + JodaBeanUtils.hashCode(fieldName);
    hash = hash * 31 + JodaBeanUtils.hashCode(observableSource);
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(128);
    buf.append("IndexQuoteId{");
    buf.append("index").append('=').append(index).append(',').append(' ');
    buf.append("fieldName").append('=').append(fieldName).append(',').append(' ');
    buf.append("observableSource").append('=').append(JodaBeanUtils.toString(observableSource));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code IndexQuoteId}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code index} property.
     */
    private final MetaProperty<Index> index = DirectMetaProperty.ofImmutable(
        this, "index", IndexQuoteId.class, Index.class);
    /**
     * The meta-property for the {@code fieldName} property.
     */
    private final MetaProperty<FieldName> fieldName = DirectMetaProperty.ofImmutable(
        this, "fieldName", IndexQuoteId.class, FieldName.class);
    /**
     * The meta-property for the {@code observableSource} property.
     */
    private final MetaProperty<ObservableSource> observableSource = DirectMetaProperty.ofImmutable(
        this, "observableSource", IndexQuoteId.class, ObservableSource.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "index",
        "fieldName",
        "observableSource");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 100346066:  // index
          return index;
        case 1265009317:  // fieldName
          return fieldName;
        case 1793526590:  // observableSource
          return observableSource;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends IndexQuoteId> builder() {
      return new IndexQuoteId.Builder();
    }

    @Override
    public Class<? extends IndexQuoteId> beanType() {
      return IndexQuoteId.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code index} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Index> index() {
      return index;
    }

    /**
     * The meta-property for the {@code fieldName} property.
     * @return the meta-property, not null
     */
    public MetaProperty<FieldName> fieldName() {
      return fieldName;
    }

    /**
     * The meta-property for the {@code observableSource} property.
     * @return the meta-property, not null
     */
    public MetaProperty<ObservableSource> observableSource() {
      return observableSource;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 100346066:  // index
          return ((IndexQuoteId) bean).getIndex();
        case 1265009317:  // fieldName
          return ((IndexQuoteId) bean).getFieldName();
        case 1793526590:  // observableSource
          return ((IndexQuoteId) bean).getObservableSource();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code IndexQuoteId}.
   */
  private static final class Builder extends DirectFieldsBeanBuilder<IndexQuoteId> {

    private Index index;
    private FieldName fieldName;
    private ObservableSource observableSource;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 100346066:  // index
          return index;
        case 1265009317:  // fieldName
          return fieldName;
        case 1793526590:  // observableSource
          return observableSource;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 100346066:  // index
          this.index = (Index) newValue;
          break;
        case 1265009317:  // fieldName
          this.fieldName = (FieldName) newValue;
          break;
        case 1793526590:  // observableSource
          this.observableSource = (ObservableSource) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public IndexQuoteId build() {
      return new IndexQuoteId(
          index,
          fieldName,
          observableSource);
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(128);
      buf.append("IndexQuoteId.Builder{");
      buf.append("index").append('=').append(JodaBeanUtils.toString(index)).append(',').append(' ');
      buf.append("fieldName").append('=').append(JodaBeanUtils.toString(fieldName)).append(',').append(' ');
      buf.append("observableSource").append('=').append(JodaBeanUtils.toString(observableSource));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
