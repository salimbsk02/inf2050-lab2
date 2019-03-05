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

public class LogicielPrincipal {

    public static void main(String[] args) {
        try {
            ReglesAffairesOrdreArchitectes reglesAffairesOrdreArchitectes =  new ReglesAffairesOrdreArchitectes();
            String declarationEnString = FichierLireEcrire.lireFichierEntreeVersString(args[0]);
            Declaration declaration = JSON.declarationEnStringVersObject(declarationEnString);
            Resultat resultat = reglesAffairesOrdreArchitectes.validerDeclaration(declaration);
            FichierLireEcrire.ecrireStringVersFichierDeSortie(args[1], JSON.resultatObjectVersString(resultat));
        } catch(Exception e) {
            System.out.println("Exception : " + e.toString());
        }
    }

}
