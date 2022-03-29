package com.emergentes.te_tareas;

public class Tareas {
    private int id;
    private String tarea;
    private int completado;

    public Tareas() {
    }

    public Tareas(int id, String tarea, int completado) {
        this.id = id;
        this.tarea = tarea;
        this.completado = completado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public int getCompletado() {
        return completado;
    }

    public void setCompletado(int completado) {
        this.completado = completado;
    }

    
}
