package br.com.naasp.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.naasp.models.Relatorio;

@Controller
public class RelatorioController {

	@RequestMapping(value = "gerarRelatorio", method = org.springframework.web.bind.annotation.RequestMethod.POST)
	public @ResponseBody ResponseEntity<Resource> gerarRelatorio(@RequestBody String json) {
		Relatorio relatorio;

		try {

			relatorio = new Relatorio(new JSONObject(json));
			File relatorioPDF = relatorio.toFile();
			Path path = Paths.get(relatorioPDF.getAbsolutePath());
			ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

			return ResponseEntity.ok().contentLength(relatorioPDF.length())
					.contentType(MediaType.parseMediaType("application/octet-stream")).body(resource);
		} catch (JSONException | IOException e) {
			return null;
		}

	}

}
