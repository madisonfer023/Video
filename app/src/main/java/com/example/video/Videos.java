package com.example.video;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Videos {

    private String categoria;
    private String titulo;
    private String fecha;
    private String urlnoticia;
    private String portada;

    public Videos(JSONObject a) throws JSONException {

        this.categoria = "";


        this.fecha = a.optString("fechapub", "");
        this.titulo = a.optString("titulo", "");
        this.urlnoticia = a.optString("urlvideo1", "");
        String portadaFilename = a.optString("portadaVideo", "");
        this.portada = "https://uteq.edu.ec/assets/images/videos/res-sem/" + portadaFilename;
    }

    public static ArrayList<Videos> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Videos> videoList = new ArrayList<>();
        for (int i = 0; i < datos.length() && i < 20; i++) {
            JSONObject obj = datos.getJSONObject(i);
            if (obj != null) {
                videoList.add(new Videos(obj));
            }
        }
        return videoList;
    }


    public String getCategoria() {
        return categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public String getUrlnoticia() {
        return urlnoticia;
    }

    public String getPortada() {
        return portada;
    }


    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setUrlnoticia(String urlnoticia) {
        this.urlnoticia = urlnoticia;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }
}