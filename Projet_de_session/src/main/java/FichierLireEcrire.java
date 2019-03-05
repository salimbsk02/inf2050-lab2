import org.apache.commons.io.*;
import java.io.*;

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

public class FichierLireEcrire {

    /**
     * Cette methode lit le fichier entrant, et le transforme en un objet de type String.
     * @param cheminDuFichierEntree Chemin du fichier entrant
     * @return contenuDuFichierEntreeEnString Objet de type String qui contiendra le contenu du fichier
     * transformé en chaine de caractere.
     */
    public static String lireFichierEntreeVersString(String cheminDuFichierEntree) {
        String contenuDuFichierEntreeEnString = null;
        try {
            contenuDuFichierEntreeEnString = IOUtils.toString(new FileInputStream(cheminDuFichierEntree), "UTF-8");
        } catch(Exception e) {
            System.out.println("Exception : " + e.toString());
        }
        return contenuDuFichierEntreeEnString;
    }

    /**
     * Cette methode prend le fichier transformé en String et l'utilise pour écrire dans un fichier de sortie.
     *
     * @param cheminDuFichierDeSortie Le chemin du fichier de sortie.
     * @param contenuDuFichierDeSortieEnString Le contenu du fichier de sortie.
     * Ne retourne rien.
     */
    public static void ecrireStringVersFichierDeSortie(String cheminDuFichierDeSortie, String contenuDuFichierDeSortieEnString) {
        try {
        File fichierDeSortie = new File(cheminDuFichierDeSortie);
        FileUtils.writeStringToFile(fichierDeSortie, contenuDuFichierDeSortieEnString, "UTF-8");
        } catch(Exception e) {
            System.out.println("Exception : " + e.toString());
        }
    }

}
