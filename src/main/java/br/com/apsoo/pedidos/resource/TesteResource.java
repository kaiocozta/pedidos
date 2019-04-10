package br.com.apsoo.pedidos.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/teste")
public class TesteResource {

    @RequestMapping(method = RequestMethod.GET)
    public String testeRest() {
        return "Rest Funcionou!";
    }

}
