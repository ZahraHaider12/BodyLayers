/*
 * Copyright 2017 SNOMED International, http://snomed.org
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
package org.snomed.otf.reasoner.server.service;

import org.snomed.otf.util.ZipUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class TestFileUtil {

	static List<String> readInferredRelationshipLinesTrim(File zipFile) throws IOException {
		return readLinesTrim(zipFile, "sct2_Relationship_Delta_Classification_");
	}

	static List<String> readEquivalentConceptLinesTrim(File zipFile) throws IOException {
		return readLinesTrim(zipFile, "der2_sRefset_EquivalentConceptSimpleMapDelta_Classification_");
	}

	private static List<String> readLinesTrim(File zipFile, String zipEntryNamePrefix) throws IOException {
		List<String> lines = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(ZipUtil.getZipEntryStreamOrThrow(zipFile, zipEntryNamePrefix)))) {
			String line;
			while ((line = reader.readLine()) != null) {
				lines.add(line.trim());
				System.out.println(line);
			}
		}
		return lines;
	}

	static File newTemporaryFile() throws IOException {
		return Files.createTempFile(new Date().getTime() + "", ".txt").toFile();
	}
}
