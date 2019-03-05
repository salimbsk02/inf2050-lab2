/**
 * Université du Québec à Montréal (UQAM) - INF2050 - Groupe 20 - Hiver 2019 - Équipe 12
 *
 * Projet de session
 *
 * 21/02/2019
 *
 * Salim Ben Salah, BENS02089404
 * Yanis Waly Chérid, CHEY21129402
 * Adel Ouldzeid, OULA01079704
 * Michael Tran, TRAM15049709
 * Hosni Abdelkrim, HOSA13119508
 */

public class Activite {

    private String description;
    private String categorie;
    private int heures;
    private String date;

    /**
     * Constructeur de la classe Activite vide.
     */
    public Activite() {
    }

    /**
     * Constructeur de la classe Activite.
     * @param description est une chaine de caractères qui représente la description.
     * @param categorie est une chaine de caractères qui représente la catégorie.
     * @param heures est un nombre entier qui représente les heures.
     * @param date est une chaine de caractères qui représente la date.
     */
    public Activite(String description, String categorie, int heures, String date) {
        this.description = description;
        this.categorie = categorie;
        this.heures = heures;
        this.date = date;
    }

    /**
     * getter pour la description.
     * @return description est une chaine de caractères qui représente la description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter pour la description.
     * @param description est une chaine de caractères qui représente la description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * getter pour la catégorie.
     * @return categorie est une chaine de caractères qui représente la catégorie.
     */
    public String getCategorie() {
        return categorie;
    }

    /**
     * setter pour la catégorie.
     * @param categorie est une chaine de caractères qui représente la catégorie.
     */
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    /**
     * getter pour les heures.
     * @return heures est un nombre entier qui représente les heures.
     */
    public int getHeures() {
        return heures;
    }

    /**
     * setter pour les heures.
     * @param heures est un nombre entier qui représente les heures.
     */
    public void setHeures(int heures) {
        this.heures = heures;
    }

    /**
     * getter pour la date.
     * @return date est une chaine de caractères qui représente la date.
     */
    public String getDate() {
        return date;
    }

    /**
     * setter pour la date
     * @param date est une chaine de caractères qui représente la date.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * La methode toString provenant de la classe Object
     * @return une chaine de caractères qui contient tous les attributs.
     */
    @Override
    public String toString() {
        return "Activite {" +
                "description = '" + description + '\'' +
                ", categorie = '" + categorie + '\'' +
                ", heures = " + heures +
                ", date = '" + date + '\'' +
                '}';
    }

}
