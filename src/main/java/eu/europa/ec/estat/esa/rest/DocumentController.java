//package eu.europa.ec.estat.esa.rest;
//
//import eu.europa.ec.estat.esa.service.EsaService;
//import eu.europa.ec.estat.esa.dto.ContainerElement;
//
//import eu.europa.ec.estat.esa.dto.TextBlockDto;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import org.springframework.web.bind.annotation.ResponseBody;
//
///**
// *
// * @author fabrix
// */
//@Controller
//public class DocumentController {
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(DocumentController.class);
//
//	@Autowired
//	private EsaService esaService;
//
//
//	@GetMapping(value = "/find-textblock/{id}/{ce}", produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody()
//	public ResponseEntity findTextBlock(@PathVariable("id") Integer id, @PathVariable("ce") int ce) {
//		LOGGER.info("findTextBlock({}, {})", id, ce);
//		ContainerElement containerElement = ContainerElement.fromValue(ce);
//		try {
//			TextBlockDto tb = this.esaService.fetchTextBlock(id, containerElement);
//			return new ResponseEntity(tb, HttpStatus.OK);
//		} catch (Exception ex) {
//			LOGGER.error(null, ex);
//			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//
//
//
//}
