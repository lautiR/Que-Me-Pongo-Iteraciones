package prenda;

import java.util.Arrays;
import java.util.List;

public enum TipoPrenda {
    //El tipoPrenda (Son muchos) Conoce su categoria, lo manejo con ENUMS! porq mi universo esta
    // esta delimitado
    REMERA(Categoria.SUPERIOR, Arrays.asList(Material.ALGODON,Material.TELA)),
    CAMISA(Categoria.SUPERIOR, Arrays.asList(Material.TELA,Material.ALGODON)),

    PANTALON(Categoria.INFERIOR,Arrays.asList(Material.TELA,Material.CUERO)),
    BERMUDA(Categoria.INFERIOR, Arrays.asList(Material.TELA,Material.ALGODON)),

    ZAPATO(Categoria.CALZADO, Arrays.asList(Material.CUERO)),
    ZAPATILLA(Categoria.CALZADO, Arrays.asList(Material.TELA,Material.CUERO)),

    AROS(Categoria.ACCESORIO, Arrays.asList(Material.ORO,Material.PLASTICO)),
    LENTES(Categoria.ACCESORIO, Arrays.asList(Material.ORO,Material.PLASTICO));

    private Categoria categoria;
    private List<Material> materialesAdecuados;


    TipoPrenda(Categoria categoria, List<Material> materialesAdecuados) {
        this.categoria = categoria;
        this.materialesAdecuados = materialesAdecuados;
    }

    public Categoria getCategoria() {
        return categoria;
    }
    public List<Material> materialesAdecuados() {return materialesAdecuados;}
    public boolean admiteMaterial (Material material) { return materialesAdecuados.contains(material);}
}
