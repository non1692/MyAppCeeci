package www.ceeci.mx.recyclerView;

public class Model {

    private Integer id;
    private String titulo;
    private String des;
    private Integer img;

    public Model(Integer id, String titulo, String des, Integer img) {
        this.id = id;
        this.titulo = titulo;
        this.des = des;
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }
}
