/*
 * Copyright 2024 Code Intelligence GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import com.code_intelligence.jazzer.junit.FuzzTest;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class JUnitInvalidJavaSeedTest {

  static class ConstructorBased {
    final int b;

    ConstructorBased(int a) {
      this.b = a * a;
    }
  }

  public static Stream<Arguments> seeds() {
    return Stream.of(arguments(new ConstructorBased(42)));
  }

  @MethodSource("seeds")
  @FuzzTest(maxExecutions = 10)
  void fuzzTest(ConstructorBased ignored) {}
}
