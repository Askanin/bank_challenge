package com.bankchallenge.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

    private static List<User> list = new ArrayList<>();
//    private static List<Usuario> listaUsuario = new ArrayList<>();
//    private static Integer chaveSequencial = 1;

    static {
        User user = new User();
//        user.setId(chaveSequencial++);
        user.setName("Pedro");
        user.setEmail("pedroca@mail.com");
        user.setPassword("123456");


//        Usuario u1 = new Usuario();
//        u1.setLogin("Nico");
//        u1.setSenha("123456");
//        Usuario u2 = new Usuario();
//        u2.setLogin("Felipe");
//        u2.setSenha("654321");
//        listaUsuario.add(u1);
//        listaUsuario.add(u2);
    }

    public void adiciona(User user) {
//        user.setId(Banco.chaveSequencial++);
        Banco.list.add(user);

    }

    public List<User> getUsers(){
        return Banco.list;
    }

    public void removeUser(Integer id) {

        Iterator<User> it = list.iterator();

        while(it.hasNext()) {
            User usr = it.next();

            if(usr.getId().equals(id)) {
                it.remove();
            }

        }

    }

    public User buscaUsuarioPeloId(Integer id) {
        for(User user : list) {
            if(user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

//    public Usuario existeUsuario(String login, String senha) {
//
//        for(Usuario usuario : listaUsuario) {
//            if(usuario.ehIgual(login, senha)) {
//                return usuario;
//            }
//        }
//        return null;
//    }
}
