import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        MetierProduitImpl metier = new MetierProduitImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Afficher la liste des produits");
            System.out.println("2. Rechercher un produit par ID");
            System.out.println("3. Ajouter un nouveau produit");
            System.out.println("4. Supprimer un produit par ID");
            System.out.println("5. Quitter");

            System.out.print("Choisissez une option : ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("Liste des produits :");
                    for (Produit produit : metier.getAll()) {
                        System.out.println(produit);
                    }
                    break;

                case 2:
                    System.out.print("Entrez l'ID du produit à rechercher : ");
                    long idRecherche = scanner.nextLong();
                    Produit produit = metier.findById(idRecherche);
                    if (produit != null) {
                        System.out.println("Produit trouvé : " + produit);
                    } else {
                        System.out.println("Produit introuvable !");
                    }
                    break;

                case 3:
                    System.out.println("Ajout d'un nouveau produit :");
                    System.out.print("ID : ");
                    long id = scanner.nextLong();
                    scanner.nextLine(); // Consommer la ligne restante
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Marque : ");
                    String marque = scanner.nextLine();
                    System.out.print("Prix : ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine(); // Consommer la ligne restante
                    System.out.print("Description : ");
                    String description = scanner.nextLine();
                    System.out.print("Nombre en stock : ");
                    int stock = scanner.nextInt();

                    Produit nouveauProduit = new Produit(id, nom, marque, prix, description, stock);
                    metier.add(nouveauProduit);
                    System.out.println("Produit ajouté !");
                    break;

                case 4:
                    System.out.print("Entrez l'ID du produit à supprimer : ");
                    long idSuppression = scanner.nextLong();
                    metier.delete(idSuppression);
                    System.out.println("Produit supprimé.");
                    break;

                case 5:
                    System.out.println("Au revoir !");
                    scanner.close();
                    return;

                default:
                    System.out.println("Option invalide.");
            }
        }
    }
}
