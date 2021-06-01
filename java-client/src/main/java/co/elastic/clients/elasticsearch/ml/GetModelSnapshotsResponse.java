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

package co.elastic.clients.elasticsearch.ml;

import co.elastic.clients.json.DelegatingJsonpValueParser;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.JsonpObjectBuilderParser;
import co.elastic.clients.json.JsonpObjectParser;
import co.elastic.clients.json.JsonpValueParser;
import co.elastic.clients.json.ToJsonp;
import co.elastic.clients.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;
import java.lang.Number;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: ml.get_model_snapshots.Response
public final class GetModelSnapshotsResponse implements ToJsonp {
	private final Number count;

	private final List<ModelSnapshot> modelSnapshots;

	// ---------------------------------------------------------------------------------------------

	protected GetModelSnapshotsResponse(Builder builder) {

		this.count = Objects.requireNonNull(builder.count, "count");
		this.modelSnapshots = Objects.requireNonNull(builder.modelSnapshots, "model_snapshots");

	}

	/**
	 * API name: {@code count}
	 */
	public Number count() {
		return this.count;
	}

	/**
	 * API name: {@code model_snapshots}
	 */
	public List<ModelSnapshot> modelSnapshots() {
		return this.modelSnapshots;
	}

	/**
	 * Serialize this object to JSON.
	 */
	public void toJsonp(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartObject();
		toJsonpInternal(generator, mapper);
		generator.writeEnd();
	}

	protected void toJsonpInternal(JsonGenerator generator, JsonpMapper mapper) {

		generator.writeKey("count");
		generator.write(this.count.doubleValue());

		generator.writeKey("model_snapshots");
		generator.writeStartArray();
		for (ModelSnapshot item0 : this.modelSnapshots) {
			item0.toJsonp(generator, mapper);

		}
		generator.writeEnd();

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link GetModelSnapshotsResponse}.
	 */
	public static class Builder implements ObjectBuilder<GetModelSnapshotsResponse> {
		private Number count;

		private List<ModelSnapshot> modelSnapshots;

		/**
		 * API name: {@code count}
		 */
		public Builder count(Number value) {
			this.count = value;
			return this;
		}

		/**
		 * API name: {@code model_snapshots}
		 */
		public Builder modelSnapshots(List<ModelSnapshot> value) {
			this.modelSnapshots = value;
			return this;
		}

		/**
		 * API name: {@code model_snapshots}
		 */
		public Builder modelSnapshots(ModelSnapshot... value) {
			this.modelSnapshots = Arrays.asList(value);
			return this;
		}

		/**
		 * Add a value to {@link #modelSnapshots(List)}, creating the list if needed.
		 */
		public Builder addModelSnapshots(ModelSnapshot value) {
			if (this.modelSnapshots == null) {
				this.modelSnapshots = new ArrayList<>();
			}
			this.modelSnapshots.add(value);
			return this;
		}

		/**
		 * Set {@link #modelSnapshots(List)} to a singleton list.
		 */
		public Builder modelSnapshots(Function<ModelSnapshot.Builder, ObjectBuilder<ModelSnapshot>> fn) {
			return this.modelSnapshots(fn.apply(new ModelSnapshot.Builder()).build());
		}

		/**
		 * Add a value to {@link #modelSnapshots(List)}, creating the list if needed.
		 */
		public Builder addModelSnapshots(Function<ModelSnapshot.Builder, ObjectBuilder<ModelSnapshot>> fn) {
			return this.addModelSnapshots(fn.apply(new ModelSnapshot.Builder()).build());
		}

		/**
		 * Builds a {@link GetModelSnapshotsResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public GetModelSnapshotsResponse build() {

			return new GetModelSnapshotsResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json parser for GetModelSnapshotsResponse
	 */
	public static final JsonpValueParser<GetModelSnapshotsResponse> JSONP_PARSER = JsonpObjectBuilderParser
			.createForObject(Builder::new, GetModelSnapshotsResponse::setupGetModelSnapshotsResponseParser);

	protected static void setupGetModelSnapshotsResponseParser(
			DelegatingJsonpValueParser<GetModelSnapshotsResponse.Builder> op) {

		op.add(Builder::count, JsonpValueParser.numberParser(), "count");
		op.add(Builder::modelSnapshots, JsonpValueParser.arrayParser(ModelSnapshot.JSONP_PARSER), "model_snapshots");

	}

}