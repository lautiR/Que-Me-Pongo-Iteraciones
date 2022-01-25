package prenda;

import excepciones.*;

public class PrendaBuilder {
    private TipoPrenda tipoPrenda;
    private Colour colorPrincipal;
    private Colour colorSecundario;
    private Material material;
    private Trama trama;
    private Trama tramaPorDefecto;

    public PrendaBuilder(Trama tramaPorDefecto) {
        this.tramaPorDefecto = tramaPorDefecto;
    }

    //ESTA MAL VALIDAR EL ORDEN, ESO SE RESOLVERIA EN LA INTERFAZ GRAFICA A LO SUMO, LO QUE QUIERO, ES PODER
    //ARMAR LA PRENDA EN PASOS Y DE FORMA CONSISTENTE
    //Incluso, podria agregar validaciones en los setters, de tipo Exception para garantizar orden
    public void setTipoPrenda(TipoPrenda tipoPrenda) {
        this.tipoPrenda = tipoPrenda;
    }
    public void setTrama(Trama trama) {this.trama = trama;}

    public void setColorPrincipal(Colour colorPrincipal) {

        this.colorPrincipal = colorPrincipal;
    }

    public void setColorSecundario(Colour colorSecundario) {
        this.colorSecundario = colorSecundario;
    }

    //A modo de prueba, agrego control de orden, para q material si o si 2do, despues del Tipo!
    public void setMaterial(Material material) {

        if(!tipoPrenda.admiteMaterial(material)){
            throw new MaterialInvalidoException("Material ingresado no corresponde con el tipo Prenda");
        }
        this.material = material;
    }

    public Prenda darDeAltaPrenda() {
        this.validarPrenda();
        return new Prenda(tipoPrenda,colorPrincipal,colorSecundario,material,trama,null);
        //Deberia resetear los atributos del builder para instanciar una nueva prenda? O... podria generar un nuevo builder

    }

    //Es mas, con validaciones en los setters, este paso sería redundante
    private void validarPrenda() {
        if(tipoPrenda==null) {
            throw new TipoPrendaException("El tipo de prenda no puede ser nulo");
        }
        if(material==null) {
            throw new MaterialException("El material no puede ser nulo");
        }
        if(colorPrincipal==null) {
            throw new ColorException("El color principal no puede ser nulo");
        }
        //Enunciado Pide que la trama Lisa Venga por Defecto, no la hardcodeo! hago una validacion
        if (trama==null){trama=this.tramaPorDefecto;}
    }

    public TipoPrenda getTipoPrenda() {
        return tipoPrenda;
    }
    public Colour getColorPrincipal() {
        return colorPrincipal;
    }
    public Colour getColorSecundario() {
        return colorSecundario;
    }
    public Material getMaterial() {
        return material;
    }
}
