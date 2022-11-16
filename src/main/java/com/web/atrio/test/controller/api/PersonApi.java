package com.web.atrio.test.controller.api;


import com.web.atrio.test.domain.HttpResponse;
import com.web.atrio.test.dto.PersonDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

import static com.web.atrio.test.utils.APP_ROOT.Person_End_Point;


/**
 * author: wael
 * v1 : Rest Api
 * date : 2022
 */

@RequestMapping(Person_End_Point)
@Api("person")
public interface PersonApi {


    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "save a person", notes = "Cette methode permet d'enregistrer ou modifier une personne", response = PersonDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet Person cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet Person n'est pas valide")
    })
    ResponseEntity<HttpResponse> savePerson (@RequestBody @Valid PersonDto dto);


    @GetMapping(value = "/all" , produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste de person", notes = "Cette methode permet de chercher et renvoyer la list des person qui existent "
            + "dans la BDD", responseContainer = "List<PersonDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste de Person / Une liste vide")
    })
    ResponseEntity<HttpResponse> findAll();



    @GetMapping(value = "/page/all" , produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste de person sous forme de page", notes = "Cette methode permet de chercher et renvoyer la list des person qui existent "
            + "dans la BDD sous forme de page ", responseContainer = "List<PersonDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste de Person / Une liste vide")
    })
    ResponseEntity<HttpResponse> findAllSort(@RequestParam Optional<String>firstName,
                                             @RequestParam Optional<Integer> page,
                                             @RequestParam Optional<Integer> size);

}
