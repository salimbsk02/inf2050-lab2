import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

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

public class ReglesAffairesOrdreArchitectes {

    private static final String cycleValide = "2018-2020";
    private static final String formatDeDateValideISO8601 = "yyyy-MM-dd";
    private static final String dateDeDebutValide = "2018-04-01";
    private static final String dateDeFinValide = "2020-04-01";
    private static final String [] categoriesValide =
            {"cours",
            "atelier",
            "séminaire",
            "colloque",
            "conférence",
            "lecture dirigée",
            "présentation",
            "groupe de discussion",
            "projet de recherche",
            "rédaction professionnelle"};
    private static final int heuresTransfereesDuCyclePrecedentMinValide = 0;
    private static final int heuresTransfereesDuCyclePrecedentMaxValide = 7;
    private static final int heuresDeFormationMinValide = 40;
    private static final int heuresUnEnsembleDeCategoriesMinValide = 17;
    private static final int heuresCategoriePresentationEtProjetDeRechercheMaxValide = 23;
    private static final int heuresCategorieGroupeDeDiscussionEtRedactionProfessionnelleMaxValide = 17;
    private static final int heuresUneActiviteMinValide = 1;

    private static int heuresDeFormation = 0;
    private static int heuresUnEnsembleDeCategories = 0;
    private static boolean complet = false;
    private static int heuresDeFormationManquantes = 0;

    private static ArrayList<String> erreurs = new ArrayList<String>();

    /**
     * Cette methode verifie que le cycle passé en parametre est valide.
     * @param cycle Une chaine de caractere qui représente le cycle a verifier.
     * @return True si le cycle est valide, false dans le cas contraire.
     */
    private boolean isCycleValide(String cycle) {
        boolean isCycleValide = false;
        if (cycle.equals(cycleValide)) {
            isCycleValide = true;
        }
        return isCycleValide;
    }

    /**
     * Cette methode sert a verifier la validité de la date passé en paramétre
     * @param date Une chaine de caractére qui représente la date.
     * @return true si la date est valide. False dans le cas contraire.
     */
    private boolean isDateValide(String date) {
        boolean isDateValide = false;
        try {
            SimpleDateFormat formatDeDate = new SimpleDateFormat(formatDeDateValideISO8601);
            formatDeDate.setLenient(false);
            Date dateDeDebut = formatDeDate.parse(dateDeDebutValide);
            Date dateDeFin = formatDeDate.parse(dateDeFinValide);
            Date dateAValider = formatDeDate.parse(date);
            if (!dateAValider.before(dateDeDebut) && !dateAValider.after(dateDeFin)) {
                isDateValide = true;
            }
        } catch (Exception e) {
            System.out.println("Exception : " + e.toString());
        }
        return isDateValide;
    }

    /**
     * Parcours le tableau de catégorie valide et le compare avec la catégorie passé en parametre.
     * @param categorie Une chaine de caractere qui représente la catégorie
     * @return Un boolean. True si la catégorie fais partie du tableau. False dans le cas contraire.
     */
    private  boolean isCategorieValide(String categorie) {
        boolean isCategorieValide = false;
        categorie = categorie.toLowerCase();
        for (int i = 0; i < categoriesValide.length; i++) {
            if (categorie.equals(categoriesValide[i])) {
                isCategorieValide = true;
            }
        }
        return isCategorieValide;
    }

    /**
     * Verifie si l'heure transféré du cycle précédent est positif.
     * @param heuresTransfereesDuCyclePrecedent Un entier qui représente le ne nombres d'heure transférés du cycle
     *                                          précédent.
     * @return True si l'heure transféré du cycle précédent est positif. False dans le cas contraire.
     */
    private  boolean isHeuresTransfereesDuCyclePrecedentPositif(int heuresTransfereesDuCyclePrecedent) {
        boolean isHeuresTransfereesDuCyclePrecedentPositif = false;
        if (heuresTransfereesDuCyclePrecedent >= heuresTransfereesDuCyclePrecedentMinValide ){
            isHeuresTransfereesDuCyclePrecedentPositif = true;
        }
        return isHeuresTransfereesDuCyclePrecedentPositif;
    }

    /**
     * Verifie si l'heure transféré du cycle précédent est valide.
     * @param heuresTransfereesDuCyclePrecedent Un entier qui représente le nombre d'heures transférés du cycle
     *                                          précédent.
     * @return True si le nombre d'heures transférés du cycle précédent est valide. False dans
     * le cas contraire.
     */
    private  boolean isHeuresTransfereesDuCyclePrecedentValide(int heuresTransfereesDuCyclePrecedent) {
        boolean isHeuresTransfereesDuCyclePrecedentValide = false;
        if (heuresTransfereesDuCyclePrecedent <= heuresTransfereesDuCyclePrecedentMaxValide){
            isHeuresTransfereesDuCyclePrecedentValide = true;
        }
        return isHeuresTransfereesDuCyclePrecedentValide;
    }

    /**
     * Verifie la validité du nombre d'heures de formation.
     * @param heuresDeFormation Un entier qui représente le nombre d'heures de formation.
     * @return True si le nombre d'heures est valide. False dans le cas contraire.
     */
    private  boolean isHeuresDeFormationValide(int heuresDeFormation) {
        boolean isHeuresDeFormationValide = false;
        if (heuresDeFormation >= heuresDeFormationMinValide){
            isHeuresDeFormationValide = true;
        }
        return isHeuresDeFormationValide;
    }

    /**
     * Cette methode sert a calculer les heures de formation.
     * @param heures Un entier qui représente les heures de chaque activité.
     * @return Le nombre total d'heures de formation.
     */
    private  int calculerHeuresDeFormation(int heures) {
        heuresDeFormation = heuresDeFormation + heures;
        return heuresDeFormation;
    }

    /**
     * Cette methode sert à verifier la validité des heures d'un ensemble de catégorie d'activité.
     * @param heuresUnEnsembleDeCategories Un entier qui représente le nombre d'heures d'un ensemble de catégories
     *                                     d'activités.
     * @param heuresTransfereesDuCyclePrecedent Un entier qui représente les heures transférés du cycle précédent.
     * @return True si l'ensemble des heures de catégorie d'activité est valide. False dans le cas contraire.
     */
    private  boolean isHeuresUnEnsembleDeCategoriesValide(int heuresUnEnsembleDeCategories, int heuresTransfereesDuCyclePrecedent) {
        boolean isHeuresUnEnsembleDeCategoriesValide = false;
        if ((heuresUnEnsembleDeCategories + heuresTransfereesDuCyclePrecedent) >= heuresUnEnsembleDeCategoriesMinValide){
            isHeuresUnEnsembleDeCategoriesValide = true;
        }
        return isHeuresUnEnsembleDeCategoriesValide;
    }

    /**
     * Cette methode fait le calcul de l'ensemble des heures des catégories.
     * @param heuresCategorie Un entier qui représente les heures pour chaque catégorie.
     * @return L'ensemble des heures pour les catégories.
     */
    private  int calculerHeuresUnEnsembleDeCategories(int heuresCategorie) {
        heuresUnEnsembleDeCategories = heuresUnEnsembleDeCategories + heuresCategorie;
        return heuresUnEnsembleDeCategories;
    }

    /**
     *Cette methode fait la verification des heures déclarés pour les categories presentation et Projet de
     * recherche.
     * @param heuresCategorie Un entier qui représente les heures.
     * @return True si les heures déclarés sont valide. False dans le cas contraire.
     */
    private  boolean isHeuresCategoriePresentationEtProjetDeRechercheValide(int heuresCategorie) {
        boolean isHeuresCategoriePresentationEtProjetDeRechercheValide = false;
        if (heuresCategorie <= heuresCategoriePresentationEtProjetDeRechercheMaxValide){
            isHeuresCategoriePresentationEtProjetDeRechercheValide = true;
        }
        return isHeuresCategoriePresentationEtProjetDeRechercheValide;
    }

    /**
     *Cette methode fait la verification des heures déclarés pour les categories groupe de discussion
     *  et projet de recherche.
     * @param heuresCategorie Un entier qui représente les heures.
     * @return True si les heures déclarés sont valide. False dans le cas contraire.
     */
    private  boolean isHeuresCategorieGroupeDeDiscussionEtRedactionProfessionnelleValide(int heuresCategorie) {
        boolean isHeuresCategorieGroupeDeDiscussionEtRedactionProfessionnelleValide = false;
        if (heuresCategorie <= heuresCategorieGroupeDeDiscussionEtRedactionProfessionnelleMaxValide){
            isHeuresCategorieGroupeDeDiscussionEtRedactionProfessionnelleValide = true;
        }
        return isHeuresCategorieGroupeDeDiscussionEtRedactionProfessionnelleValide;
    }

    /**
     * Cette méthode permet de valider le nombre d'heure
     * @param heures représente un entier de nombre d'heure
     * @return true si le nombre d'heure est valide et false dans le cas contraire
     */
    private  boolean isHeuresUneActiviteValide(int heures) {
        boolean isHeuresUneActiviteValide = false;
        if (heures >= heuresUneActiviteMinValide){
            isHeuresUneActiviteValide = true;
        }
        return isHeuresUneActiviteValide;
    }

    /**
     * @params activite représente un objet de la classe Activite
     * Cette méthode permet de valider une activité et remplie le tableau d'erreurs si
     * elle n'est pas valide.
     **/
    private void validerActivite(Activite activite) {

        if(isCategorieValide(activite.getCategorie())
                && isHeuresUneActiviteValide(activite.getHeures())
                && isDateValide(activite.getDate())) {

            if (activite.getCategorie().equals(categoriesValide[6])
                    || activite.getCategorie().equals(categoriesValide[8])) {

                if (isHeuresCategoriePresentationEtProjetDeRechercheValide(activite.getHeures())) {
                    heuresDeFormation = calculerHeuresDeFormation(activite.getHeures());
                } else {
                    heuresDeFormation = calculerHeuresDeFormation
                            (heuresCategoriePresentationEtProjetDeRechercheMaxValide);
                }

            } else if (activite.getCategorie().equals(categoriesValide[7])
                    || activite.getCategorie().equals(categoriesValide[9])) {

                if (isHeuresCategorieGroupeDeDiscussionEtRedactionProfessionnelleValide(activite.getHeures())) {
                    heuresDeFormation = calculerHeuresDeFormation(activite.getHeures());
                } else {
                    heuresDeFormation = calculerHeuresDeFormation
                            (heuresCategorieGroupeDeDiscussionEtRedactionProfessionnelleMaxValide);
                }
            } else {
                heuresUnEnsembleDeCategories = calculerHeuresUnEnsembleDeCategories(activite.getHeures());
            }

        } else {

            if (!isCategorieValide(activite.getCategorie())) {
                String erreur1 = "L'activité " + activite.getDescription() + " utilise une catégorie " +
                        "non reconnue. Elle sera ignorée.";
                erreurs.add(erreur1);
            }
            if (!isDateValide(activite.getDate())) {
                String erreur2 = "L'activité " + activite.getDescription() + " déclarée a été complétée " +
                        "à l'extérieur de l'intervalle de date valide. Elle sera ignorée.";
                erreurs.add(erreur2);
            }
            if (!isHeuresUneActiviteValide(activite.getHeures())) {
                String erreur3 = "L'activité " + activite.getDescription() + " possède une heure invalide. " +
                        "Elle sera ignorée.";
                erreurs.add(erreur3);
            }
        }
    }

    /**
     * @params declaration représente un objet de la classe Declaration
     * Cette méthode permet de valider les objets de la classe Declaration et d'afficher des messages d'erreurs
     * personalisés dépendament de l'invaliditer des objets.
     * @return un objet resultat contenant tous les messages d'erreurs
     **/
    public Resultat validerDeclaration (Declaration declaration) {

        if(isCycleValide(declaration.getCycle())) {

            for (int i = 0; i < declaration.getActivites().size(); i++) {
                    validerActivite(declaration.getActivites().get(i));
            }

            if(isHeuresTransfereesDuCyclePrecedentPositif(declaration.getHeuresTransfereesDuCyclePrecedent())) {

                if(isHeuresTransfereesDuCyclePrecedentValide(declaration.getHeuresTransfereesDuCyclePrecedent())) {
                    heuresDeFormation = calculerHeuresDeFormation(declaration.getHeuresTransfereesDuCyclePrecedent());

                    if (isHeuresUnEnsembleDeCategoriesValide
                            (heuresUnEnsembleDeCategories, declaration.getHeuresTransfereesDuCyclePrecedent())){
                        heuresDeFormation = calculerHeuresDeFormation(heuresUnEnsembleDeCategories);
                    } else {
                        heuresDeFormation = calculerHeuresDeFormation(heuresUnEnsembleDeCategories);
                        String erreur7 = "La somme des heures déclarées des activités appartenants à l'ensemble suivant " +
                                "de catégories : cours, atelier, séminaire, colloque, conférence, lecture dirigée, " +
                                "doit être supérieure ou égale à 17 (les heures transférées du cycle précédent ont " +
                                "été comptabilisées dans cette somme)";
                        erreurs.add(erreur7);
                    }

                } else {

                    heuresDeFormation = calculerHeuresDeFormation(heuresTransfereesDuCyclePrecedentMaxValide);
                    String erreur6 = "Les heures transférées complétées lors du cycle précédent ne doivent pas être " +
                            "supérieur à 7. Uniquement 7 heures seront considérées lors des calculs";
                    erreurs.add(erreur6);

                    if (isHeuresUnEnsembleDeCategoriesValide
                            (heuresUnEnsembleDeCategories, heuresTransfereesDuCyclePrecedentMaxValide)){
                        heuresDeFormation = calculerHeuresDeFormation(heuresUnEnsembleDeCategories);
                    } else {
                        heuresDeFormation = calculerHeuresDeFormation(heuresUnEnsembleDeCategories);
                        String erreur8 = "La somme des heures déclarées des activités appartenants à l'ensemble suivant " +
                                "de catégories : cours, atelier, séminaire, colloque, conférence, lecture dirigée, " +
                                "doit être supérieure ou égale à 17 (les heures transférées du cycle précédent ont " +
                                "été comptabilisées dans cette somme)";
                        erreurs.add(erreur8);
                    }

                }

            } else {

                if (isHeuresUnEnsembleDeCategoriesValide(heuresUnEnsembleDeCategories, heuresTransfereesDuCyclePrecedentMinValide)){
                    heuresDeFormation = calculerHeuresDeFormation(heuresUnEnsembleDeCategories);
                } else {
                    heuresDeFormation = calculerHeuresDeFormation(heuresUnEnsembleDeCategories);
                    String erreur9 = "La somme des heures déclarées des activités appartenants à l'ensemble suivant " +
                            "de catégories : cours, atelier, séminaire, colloque, conférence, lecture dirigée, " +
                            "doit être supérieure ou égale à 17 (les heures transférées du cycle précédent ont " +
                            "été comptabilisées dans cette somme)";
                    erreurs.add(erreur9);
                }

                String erreur5 = "Les heures transférées complétées lors du cycle précédent ne peuvent pas être négatives. " +
                        "Elles seront ignorées.";
                erreurs.add(erreur5);
            }

        } else {
            String erreur4 = "La déclaration utilise un cycle invalide. Uniquement le cycle 2018-2020 est supporté";
            erreurs.add(erreur4);
        }

        if(isHeuresDeFormationValide(heuresDeFormation)){
            complet = true;
        } else {
            heuresDeFormationManquantes = (heuresDeFormationMinValide - heuresDeFormation);
            String erreur10 = "Il manque " + heuresDeFormationManquantes + " heures de formation " +
                    "pour compléter le cycle.";
            erreurs.add(erreur10);
        }
        Resultat resultat = new Resultat(complet, erreurs);
        return resultat;
    }

}
