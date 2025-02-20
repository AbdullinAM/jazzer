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

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import com.code_intelligence.jazzer.junit.FuzzTest;

class CommandLineFuzzTest {
  int run = 0;

  @FuzzTest
  void commandLineFuzz(byte[] bytes) {
    assumeTrue(bytes.length > 0);
    switch (run++) {
      case 0:
        throw new RuntimeException();
      case 1:
        throw new IllegalStateException();
      case 2:
        throw new Error();
    }
  }
}
