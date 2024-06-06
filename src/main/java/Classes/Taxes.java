package Classes;

public class Taxes {
    private double sssDeduction;
    private double philhealthDeduction;
    private double pagibigDeduction;
    private double withholdingTaxDeduction;

    // Constructor
    public Taxes(double sssDeduction, double philhealthDeduction, double pagibigDeduction, double withholdingTaxDeduction) {
        this.sssDeduction = sssDeduction;
        this.philhealthDeduction = philhealthDeduction;
        this.pagibigDeduction = pagibigDeduction;
        this.withholdingTaxDeduction = withholdingTaxDeduction;
    }

    // Method to calculate total deductions
    public double calculateTotalDeductions(double grossSalary) {
        return sssDeduction + philhealthDeduction + pagibigDeduction + withholdingTaxDeduction;
    }

    // Method to calculate SSS deduction based on gross salary
    public static double calculateSssDeduction(double grossSalary) {
        double[] sssContributionRanges = {
            3250, 3750, 4250, 4750, 5250, 5750, 6250, 6750, 7250, 7750, 8250, 8750, 9250, 9750, 10250,
            10750, 11250, 11750, 12250, 12750, 13250, 13750, 14250, 14750, 15250, 15750, 16250, 16750,
            17250, 17750, 18250, 18750, 19250, 19750, 20250, 20750, 21250, 21750, 22250, 22750, 23250,
            23750, 24250, 24750
        };
        double[] sssContributions = {
            135.00, 157.50, 180.00, 202.50, 225.00, 247.50, 270.00, 292.50, 315.00, 337.50, 360.00, 382.50,
            405.00, 427.50, 450.00, 472.50, 495.00, 517.50, 540.00, 562.50, 585.00, 607.50, 630.00, 652.50,
            675.00, 697.50, 720.00, 742.50, 765.00, 787.50, 810.00, 832.50, 855.00, 877.50, 900.00, 922.50,
            945.00, 967.50, 990.00, 1012.50, 1035.00, 1057.50, 1080.00, 1102.50, 1125.00
        };

        for (int i = 0; i < sssContributionRanges.length; i++) {
            if (grossSalary <= sssContributionRanges[i]) {
                return sssContributions[i];
            }
        }
        return 1125.00; // If grossSalary is higher than the last range
    }

    // Method to calculate PhilHealth deduction based on monthly basic salary
    public static double calculatePhilhealthDeduction(double monthlyBasicSalary) {
        if (monthlyBasicSalary <= 10000) {
            return 300;
        } else if (monthlyBasicSalary <= 59999.99) {
            return 300 + (0.03 * (monthlyBasicSalary - 10000));
        } else {
            return 1800;
        }
    }

    // Method to calculate PAGIBIG deduction based on monthly basic salary
    public static double calculatePagibigDeduction(double monthlyBasicSalary) {
        if (monthlyBasicSalary >= 1000 && monthlyBasicSalary <= 1500) {
            return monthlyBasicSalary * 0.01;
        } else {
            return monthlyBasicSalary * 0.02;
        }
    }

    // Method to calculate withholding tax based on monthly salary and deductions
    public static double calculateWithholdingTax(double monthlySalary, double sssDeduction, double philhealthDeduction, double pagibigDeduction) {
        // Calculate total deductions
        double totalDeductions = sssDeduction + philhealthDeduction + pagibigDeduction;
    
        // Calculate taxable income after deductions
        double taxableIncome = monthlySalary - totalDeductions;

        // Calculate withholding tax based on taxable income
        if (taxableIncome <= 20832) {
            return 0;
        } else if (taxableIncome <= 33333) {
            return (taxableIncome - 20833) * 0.20;
        } else if (taxableIncome <= 66667) {
            return 2500 + (taxableIncome - 33333) * 0.25;
        } else if (taxableIncome <= 166667) {
            return 10833.33 + (taxableIncome - 66667) * 0.30;
        } else if (taxableIncome <= 666667) {
            return 40833.33 + (taxableIncome - 166667) * 0.32;
        } else {
            return 200833.33 + (taxableIncome - 666667) * 0.35;
        }
    }


    // Getters and setters
    public double getSssDeduction() {
        return sssDeduction;
    }

    public void setSssDeduction(double sssDeduction) {
        this.sssDeduction = sssDeduction;
    }

    public double getPhilhealthDeduction() {
        return philhealthDeduction;
    }

    public void setPhilhealthDeduction(double philhealthDeduction) {
        this.philhealthDeduction = philhealthDeduction;
    }

    public double getPagibigDeduction() {
        return pagibigDeduction;
    }

    public void setPagibigDeduction(double pagibigDeduction) {
        this.pagibigDeduction = pagibigDeduction;
    }

    public double getWithholdingTaxDeduction() {
        return withholdingTaxDeduction;
    }

    public void setWithholdingTaxDeduction(double withholdingTaxDeduction) {
        this.withholdingTaxDeduction = withholdingTaxDeduction;
    }
}
