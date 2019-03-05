import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
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
/**
 * Copyright 2015 Jacques Berger.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class JSON {

    /**
     * @params declarationEnString représente une chaine de caractère du fichier lu
     * Cette méthode permet de transformer une chaine de caractère en un
     * objet.
     * @return un objet declaration qui contient les information lu du fichier
     */
    public static Declaration declarationEnStringVersObject(String declarationEnString){
        Declaration declaration = new Declaration();
        try {
            JSONObject jsonDeclaration = (JSONObject) JSONSerializer.toJSON(declarationEnString);
            String numeroDePermis = jsonDeclaration.getString("numero_de_permis");
            String cycle = jsonDeclaration.getString("cycle");
            int heuresTransfereesDuCyclePrecedent = jsonDeclaration.getInt("heures_transferees_du_cycle_precedent");
            JSONArray jsonActivites = (JSONArray) jsonDeclaration.get("activites");
            ArrayList<Activite> activites = activitesJSONArrayVersArrayList(jsonActivites);
            declaration = new Declaration(numeroDePermis, cycle, heuresTransfereesDuCyclePrecedent, activites);
        } catch(Exception e) {
            System.out.println("Exception : " + e.toString());
        }
        return declaration;
    }

    /**
     * @params jsonActivites représente un tableau d'objets d'activitées
     * Cette méthode permet de placer toutes les activiées dans le tableau d'ArrayList
     * @return le tableau d'actctivité
     */
    private static ArrayList<Activite> activitesJSONArrayVersArrayList(JSONArray jsonActivites) {
        ArrayList<Activite> activites = new ArrayList<Activite>();
        for (int i = 0; i < jsonActivites.size(); i++) {
            JSONObject jsonActivite = jsonActivites.getJSONObject(i) ;
            String description = jsonActivite.getString("description");
            String categorie = jsonActivite.getString("categorie");
            int heures =  jsonActivite.getInt("heures");
            String date = jsonActivite.getString("date");
            activites.add(new Activite(description, categorie, heures, date));
        }
        return activites;
    }

    /**
     * @params resultat représente un objet de la classe Resultat
     * Cette méthode permet de tranformer un résultat en une chaine de caractère
     * @return une chaine de caractère
     */
    public static String resultatObjectVersString(Resultat resultat) {
        String resultatEnString = null;
        try {
            JSONObject jsonResultat = new JSONObject();
            jsonResultat.accumulate("complet", resultat.isComplet());
            JSONArray jsonErreurs = new JSONArray();
            for (String erreur : resultat.getErreurs()) {
                jsonErreurs.add(erreur);
            }
            jsonResultat.accumulate("erreur", jsonErreurs);
            resultatEnString = jsonResultat.toString(2);
        } catch(Exception e) {
            System.out.println("Exception : " + e.toString());
        }
        return resultatEnString;
    }

}
