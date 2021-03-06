/*
 * Copyright (C) 2020 Square, Inc. and others.
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
package okio.internal

/** A cryptographic hash function. */
interface HashFunction {
  fun update(input: ByteArray, offset: Int, byteCount: Int)

  fun digest(): ByteArray
}

fun newHashFunction(name: String): HashFunction = when (name) {
  "SHA-1" -> Sha1()
  "SHA-256" -> Sha256()
  "SHA-512" -> Sha512()
  "MD5" -> Md5()
  else -> error("Invalid algorithm $name")
}
