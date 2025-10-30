
public class FertilizerAdvisorySystem_24rp01786{


    public static void processSamples(SoilAnalysis[] samples) {
        int balancedCount = 0;
        int deficientCount = 0;
        int totalValidSamples = 0;

        System.out.println("\n=======================================================");
        System.out.println("            IHINDUKA CONNECT - ADVISORY REPORT");
        System.out.println("=======================================================");

        // Uses a loop to process each soil analysis
        for (SoilAnalysis sample : samples) {
            // Uses exception handling to catch and handle IllegalArgumentException
            try {
                // Check for invalid (non-positive) data which will trigger the exception in the calculation methods
                if (sample.getNitrogenLevel() <= 0 || sample.getPhosphorusLevel() <= 0 || sample.getPotassiumLevel() <= 0) {
                    throw new IllegalArgumentException("Invalid nutrient reading: One or more levels are non-positive.");
                }

                // Get recommendations (will throw exception if any value is <= 0)
                String nitrogenRec = sample.calculateFertilizerNeeded("Nitrogen");
                String phosphorusRec = sample.calculateFertilizerNeeded("Phosphorus");
                String potassiumRec = sample.calculateFertilizerNeeded("Potassium");

                // Prints farmer ID, district, crop type, and fertilizer recommendation for valid samples
                System.out.println("\n--- Valid Sample Processed ---");
                System.out.println("Farmer ID: " + sample.getFarmerId());
                System.out.println("District: " + sample.getDistrictName());
                System.out.println("Crop Type: " + sample.getCropType());

                System.out.println("  Nitrogen Recommendation: " + nitrogenRec);
                System.out.println("  Phosphorus Recommendation: " + phosphorusRec);
                System.out.println("  Potassium Recommendation: " + potassiumRec);

                // Update counts for balanced vs. deficient (one of the counts to be displayed at the end)
                if (sample.isBalanced()) {
                    balancedCount++;
                } else if (nitrogenRec.contains("DEFICIENT") || phosphorusRec.contains("DEFICIENT") || potassiumRec.contains("DEFICIENT")) {
                    deficientCount++;
                }
                totalValidSamples++;

            } catch (IllegalArgumentException e) {
                // For invalid samples, prints an error message and continues processing remaining samples
                System.err.println("\n!!! ERROR Processing Sample for Farmer ID: " + sample.getFarmerId() + " !!!");
                System.err.println("  Reason: " + e.getMessage());
                System.err.println("  Action: Error printed. Continuing to next sample.");
            }
        }

        System.out.println("\n=======================================================");
        // Counts and displays the total number of balanced vs. deficient soil samples at the end
        System.out.println("ADVISORY SUMMARY (from " + totalValidSamples + " valid samples):");
        System.out.println("  Total Balanced Samples: " + balancedCount);
        System.out.println("  Total Deficient Samples: " + deficientCount); // Note: This is a simplified count
        System.out.println("=======================================================");
    }

    // Main Method
    public static void main(String[] args) {
        // Create an array of at least 5 SoilAnalysis objects with diverse test data
        SoilAnalysis[] testSamples = {
                // 1. Balanced Sample (N, P, K between 20 and 100) - For Maize in Kirehe
                new SoilAnalysis("F001", "Kirehe", 50.0, 75.0, 99.0, "Maize"),

                // 2. Deficient Sample (P < 20) - For Rice in Bugesera
                new SoilAnalysis("F002", "Bugesera", 60.0, 15.0, 80.0, "Rice"),

                // 3. Excess Sample (N > 100) - For Beans in Nyagatare
                new SoilAnalysis("F003", "Nyagatare", 110.0, 50.0, 30.0, "Beans"),

                // 4. Invalid Data (Negative value for K) - To trigger IllegalArgumentException
                new SoilAnalysis("F004_ERROR", "Rwamagana", 45.0, 70.0, -5.0, "Sorghum"),

                // 5. Highly Deficient Sample (All < 20) - Another deficient sample
                new SoilAnalysis("F005", "Musanze", 10.0, 12.0, 18.0, "Irish Potatoes"),

                // 6. Another Excess Sample
                new SoilAnalysis("F006", "Huye", 150.0, 120.0, 105.0, "Coffee")
        };

        // Call the processSamples method to generate the advisory report
        processSamples(testSamples);
    }
}