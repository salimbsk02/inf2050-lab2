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

public class Resultat {

    private boolean complet;
    private ArrayList<String> erreurs;

    /**
     * Constructeur de la classe resultat vide.
     */
    public Resultat() {
    }

    /**
     * Constructeur de la classe resultat.
     * @param complet Un boolean relié aux heures de formation
     * @param erreurs Un tableau dynamique de type erreurs.
     */
    public Resultat(boolean complet, ArrayList<String> erreurs) {
        this.complet = complet;
        this.erreurs = erreurs;
    }

    /**
     * Un getter pour l'objet complet.
     * @return l'objet complet.
     */
    public boolean isComplet() {
        return complet;
    }

    /**
     * un setter pour l'objet complet.
     * @param complet Un objet complet de type boolean.
     */
    public void setComplet(boolean complet) {
        this.complet = complet;
    }

    /**
     * Un getter pour l'objet erreurs qui est de type ArrayList.
     * @return erreurs L'objet erreurs.
     */
    public ArrayList<String> getErreurs() {
        return erreurs;
    }

    /**
     * Un setter pour l'objet erreurs.
     * @param erreurs Un objet erreurs de type ArrayList.
     */
    public void setErreurs(ArrayList<String> erreurs) {
        this.erreurs = erreurs;
    }

    /**
     * Methode toString de la classe Object pour afficher les objets de la classe courante.
     * @return Une chaine de caractere qui affiche les objets de la calsse courante.
     */
    @Override
    public String toString() {
        return "Resultat {" +
                "complet = " + complet +
                ", erreurs = " + erreurs +
                '}';
    }

}
