import java.util.ArrayList;

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

public class Declaration {

    private String numeroDePermis;
    private String cycle;
    private int heuresTransfereesDuCyclePrecedent;
    private ArrayList<Activite> activites;

    /**
     * Constructeur de la classe Declaration vide.
     */
    public Declaration() {
    }

    /**
     * Constructeur de la classe Declaration.
     * @params numeroDePermis est une chaine de caractères qui représente le numéro de permis.
     * @params cycle est une chaine de caractères qui représente le cycle.
     * @params heuresTransfereesDuCyclePrecedent est une chaine de caractères qui représente
     * les heures transférées du cycle précédent.
     * @params activites est un tableau dynamique d'activités qui représente les divers activités.
     */
    public Declaration(String numeroDePermis, String cycle, int heuresTransfereesDuCyclePrecedent, ArrayList<Activite> activites) {
        this.numeroDePermis = numeroDePermis;
        this.cycle = cycle;
        this.heuresTransfereesDuCyclePrecedent = heuresTransfereesDuCyclePrecedent;
        this.activites = activites;
    }

    /**
     * getter pour le numéro de permis.
     * @return numeroDePermis est une chaine de caractères qui représente le numéro de permis.
     */
    public String getNumeroDePermis() {
        return numeroDePermis;
    }

    /**
     * setter pour le numéro de permis.
     * @params numeroDePermis est une chaine de caractères qui représente le numéro de permis.
     */
    public void setNumeroDePermis(String numeroDePermis) {
        this.numeroDePermis = numeroDePermis;
    }

    /**
     * getter pour le cycle.
     * @return cycle est une chaine de caractères qui représente le cycle.
     */
    public String getCycle() {
        return cycle;
    }

    /**
     * setter pour le cycle.
     * @params cycle est une chaine de caractères qui représente le cycle.
     */
    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    /**
     * getter pour les heures transférées du cycle précédent.
     * @return heuresTransfereesDuCyclePrecedent est une chaine de caractères qui représente
     * les heures transférées du cycle précédent.
     */
    public int getHeuresTransfereesDuCyclePrecedent() {
        return heuresTransfereesDuCyclePrecedent;
    }

    /**
     * setter pour les heures transférées du cycle précédent.
     * @params heuresTransfereesDuCyclePrecedent est une chaine de caractères qui représente
     * les heures transférées du cycle précédent.
     */
    public void setHeuresTransfereesDuCyclePrecedent(int heuresTransfereesDuCyclePrecedent) {
        this.heuresTransfereesDuCyclePrecedent = heuresTransfereesDuCyclePrecedent;
    }

    /**
     * getter pour le tableau dynamique d'activités.
     * @return activites est un tableau dynamique d'activités qui représente les divers activités.
     */
    public ArrayList<Activite> getActivites() {
        return activites;
    }

    /**
     * setter pour le tableau dynamique d'activités.
     * @params activites est un tableau dynamique d'activités qui représente les divers activités.
     */
    public void setActivites(ArrayList<Activite> activites) {
        this.activites = activites;
    }

    /**
     * La méthode toString provenant de la classe Object.
     * @return une chaine de caractères qui contient tous les attributs.
     */
    @Override
    public String toString() {
        return "Declaration {" +
                "numeroDePermis = '" + numeroDePermis + '\'' +
                ", cycle = '" + cycle + '\'' +
                ", heuresTransfereesDuCyclePrecedent = " + heuresTransfereesDuCyclePrecedent +
                ", activites = " + activites +
                '}';
    }

}
