package learn.sfg.sfgtestjunit5.controllers;

public class IndexController {

    public String index(){
        return "index";
    }

    public String oupsHandler(){
        throw new ValueNotFoundException();
    }
}
