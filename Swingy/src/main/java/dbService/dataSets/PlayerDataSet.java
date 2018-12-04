package dbService.dataSets;

import javax.persistence.*;

@Entity
@Table(name= "players")
public class PlayerDataSet {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;

    @Column(name = "name")
    private final String name;

    @Column(name = "class")
    private final String pClass;

    @Column(name = "level")
    private int level;

    @Column(name = "experience")
    private int experience;

    @Column(name = "attack")
    private int attack;

    @Column(name = "defense")
    private int defense;

    @Column(name = "hit_points")
    private int hitPoints;

    @Column(name = "weapon_name")
    private String weaponName;

    @Column(name = "inc_attack")
    private int incAttack;

    @Column(name = "armor_name")
    private String armorName;

    @Column(name = "inc_defense")
    private int incDefense;

    @Column(name = "helm_name")
    private String helmName;

    @Column(name = "inc_hit_points")
    private int incHitPoints;

    public PlayerDataSet(long id, String name, String pClass){
        this.id = id;
        this.name = name;
        this.pClass = pClass;
        level = 0;
        experience = 0;
    }



}
