package pro.neo.nowup.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "pets")
public abstract class Pet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "Id")
    private User owner;

    @Size(max = 50)
    @NotNull
    @Column(name = "name", length = 50)
    private String name;

    @ManyToOne()
    @JoinColumn(name = "id")
    private TypeOfPet typeOfPet;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "pet",fetch = FetchType.LAZY)
    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Disease> diseaseHistory;

    public Pet() {}

    public Pet(User owner, String name, TypeOfPet typeOfPet, int age, List<Disease> diseaseHistory) {
        this.owner = owner;
        this.name = name;
        this.typeOfPet = typeOfPet;
        this.age = age;
        this.diseaseHistory = diseaseHistory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet pet = (Pet) o;

        if (age != pet.age) return false;
        if (id != null ? !id.equals(pet.id) : pet.id != null) return false;
        if (!owner.equals(pet.owner)) return false;
        if (!name.equals(pet.name)) return false;
        if (!typeOfPet.equals(pet.typeOfPet)) return false;
        return diseaseHistory != null ? diseaseHistory.equals(pet.diseaseHistory) : pet.diseaseHistory == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + owner.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + typeOfPet.hashCode();
        result = 31 * result + age;
        result = 31 * result + (diseaseHistory != null ? diseaseHistory.hashCode() : 0);
        return result;
    }
}
