// Copyright 2017 The Promagent Authors
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package io.promagent.internal.metrics;

import java.util.Map;

public class Histogram implements HistogramMBean {

    private final io.prometheus.client.Histogram histogram;

    public Histogram(io.prometheus.client.Histogram histogram) {
        this.histogram = histogram;
    }

    @Override
    public void observe(double value, String... labelValues) {
        histogram.labels(labelValues).observe(value);
    }

    @Override
    public Map<Map<String, String>, Double> getValues() {
        return MetricsUtil.getValues(histogram);
    }
}