package fr.miage.saez.TP2;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnalyseurDeClasse {
    private Class cl;

    public AnalyseurDeClasse(Object o){
        this.cl = o.getClass();
        System.out.println("CLASS ANALYSE = " + cl.getName());
    }
    private void affichePackage(){
        System.out.println("PACKAGE = " + cl.getPackage().getName());
    }

    private void afficheAttributs() {
        System.out.println("---Fields---");
        for (Field field : cl.getDeclaredFields()){
            System.out.println(field);
        }
    }

    private void afficheConstructeurs() {
        System.out.println("---Constructors---");
        for (Constructor constructor : cl.getConstructors()){
            System.out.println(constructor);
        }

    }

    private void afficheMethodes() {
        System.out.println("---Methods---");
        for (Method method : cl.getDeclaredMethods()){
            System.out.println(method);
        }
    }

    private void afficheHeritageInterface() {
        System.out.println("---extends---");
        System.out.println(cl.getSuperclass().getName());
        System.out.println("---implements---");
        for (Class c : cl.getInterfaces()){
            System.out.println(c.getName());
        }
    }

    static public void main(String[] args) {
        AnalyseurDeClasse analyseurDeClasse = new AnalyseurDeClasse(new Polygon());
        analyseurDeClasse.affichePackage();
        analyseurDeClasse.afficheHeritageInterface();
        analyseurDeClasse.afficheConstructeurs();
        analyseurDeClasse.afficheMethodes();
        analyseurDeClasse.afficheAttributs();


    }
}
