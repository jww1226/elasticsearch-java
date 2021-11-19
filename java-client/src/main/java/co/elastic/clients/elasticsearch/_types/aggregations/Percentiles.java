/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package co.elastic.clients.elasticsearch._types.aggregations;

import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.JsonpSerializable;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.json.UnionDeserializer;
import co.elastic.clients.util.ModelTypeHelper;
import co.elastic.clients.util.ObjectBuilder;
import co.elastic.clients.util.ObjectBuilderBase;
import co.elastic.clients.util.TaggedUnion;
import co.elastic.clients.util.TaggedUnionUtils;
import jakarta.json.stream.JsonGenerator;
import java.lang.Object;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: _types.aggregations.Percentiles
// union type: Union[]
@JsonpDeserializable
public class Percentiles implements TaggedUnion<Object>, JsonpSerializable {

	public static final String ARRAY = "array";
	public static final String KEYED = "keyed";

	private final String _type;
	private final Object _value;

	@Override
	public final String _type() {
		return _type;
	}

	@Override
	public final Object _get() {
		return _value;
	}

	public Percentiles(String type, Object value) {
		this._type = type;
		this._value = value;
	}

	private Percentiles(Builder builder) {

		this._type = ModelTypeHelper.requireNonNull(builder._type, builder, "<variant type>");
		this._value = ModelTypeHelper.requireNonNull(builder._value, builder, "<variant value>");

	}

	public static Percentiles of(Function<Builder, ObjectBuilder<Percentiles>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Is this variant instance of kind {@code array}?
	 */
	public boolean _isArray() {
		return ARRAY.equals(_type());
	}

	/**
	 * Get the {@code array} variant value.
	 *
	 * @throws IllegalStateException
	 *             if the current variant is not of the {@code array} kind.
	 */
	public List<ArrayPercentilesItem> array() {
		return TaggedUnionUtils.get(this, ARRAY);
	}

	/**
	 * Is this variant instance of kind {@code keyed}?
	 */
	public boolean _isKeyed() {
		return KEYED.equals(_type());
	}

	/**
	 * Get the {@code keyed} variant value.
	 *
	 * @throws IllegalStateException
	 *             if the current variant is not of the {@code keyed} kind.
	 */
	public Map<String, String> keyed() {
		return TaggedUnionUtils.get(this, KEYED);
	}

	@Override
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {
		if (_value instanceof JsonpSerializable) {
			((JsonpSerializable) _value).serialize(generator, mapper);
		} else {
			switch (_type) {
				case ARRAY :
					generator.writeStartArray();
					for (ArrayPercentilesItem item0 : ((List<ArrayPercentilesItem>) this._value)) {
						item0.serialize(generator, mapper);

					}
					generator.writeEnd();

					break;
				case KEYED :
					generator.writeStartObject();
					for (Map.Entry<String, String> item0 : ((Map<String, String>) this._value).entrySet()) {
						generator.writeKey(item0.getKey());
						generator.write(item0.getValue());

					}
					generator.writeEnd();

					break;
			}
		}

	}

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<Percentiles> {
		private String _type;
		private Object _value;

		public Builder array(List<ArrayPercentilesItem> v) {
			this._type = ARRAY;
			this._value = v;
			return this;
		}

		public Builder keyed(Map<String, String> v) {
			this._type = KEYED;
			this._value = v;
			return this;
		}

		public Percentiles build() {
			_checkSingleUse();
			return new Percentiles(this);
		}

	}

	private static JsonpDeserializer<Percentiles> buildPercentilesDeserializer() {
		return new UnionDeserializer.Builder<>(Percentiles::new, false)
				.addMember("array", JsonpDeserializer.arrayDeserializer(ArrayPercentilesItem._DESERIALIZER))
				.addMember("keyed", JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()))
				.build();
	}

	public static final JsonpDeserializer<Percentiles> _DESERIALIZER = JsonpDeserializer
			.lazy(Percentiles::buildPercentilesDeserializer);
}
