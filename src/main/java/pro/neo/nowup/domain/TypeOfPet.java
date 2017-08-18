package pro.neo.nowup.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "type_of_pet")
public class TypeOfPet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private int id;

    @Size(max = 50)
    @NotNull
    @Column(name = "name", length = 50)
    private String name;

    @Size(max = 100)
    @NotNull
    @Column(name = "description", length = 100)
    private String description;

    public TypeOfPet() {}

    public TypeOfPet(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeOfPet typeOfPet = (TypeOfPet) o;

        if (id != typeOfPet.id) return false;
        if (!name.equals(typeOfPet.name)) return false;
        return description != null ? description.equals(typeOfPet.description) : typeOfPet.description == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
