package TempConverter;

import javax.swing.JOptionPane;

public class TempConverter {

    public static void main(String[] args) {
        
        String unitFrom = JOptionPane.showInputDialog("Enter the unit you want to convert from: \n(C/F/K)");
        String unitTo = JOptionPane.showInputDialog("Enter the unit you want to convert to: \n(C/F/K)");
        double temp = Double.parseDouble(JOptionPane.showInputDialog("Enter the temperature you want to convert:"));
        double cTemp;

        if(unitFrom.equalsIgnoreCase("C") && unitTo.equalsIgnoreCase("F")) {
            cTemp = (temp*9/5)+32;
            JOptionPane.showMessageDialog(null, "That temperature is equivalent to "+cTemp+"°F");
        } else if(unitFrom.equalsIgnoreCase("C") && unitTo.equalsIgnoreCase("K")) {
            cTemp = temp+273;
            JOptionPane.showMessageDialog(null, "That temperature is equivalent to "+cTemp+"K");
        }

        if(unitFrom.equalsIgnoreCase("F") && unitTo.equalsIgnoreCase("C")) {
            cTemp = (5*(temp-32))/9;
            JOptionPane.showMessageDialog(null, "That temperature is equivalent to "+cTemp+"°C");
        } else if(unitFrom.equalsIgnoreCase("F") && unitTo.equalsIgnoreCase("K")) {
            cTemp = ((5*(temp-32))/9)+273;
            JOptionPane.showMessageDialog(null, "That temperature is equivalent to "+cTemp+"K");
        }

        if(unitFrom.equalsIgnoreCase("K") && unitTo.equalsIgnoreCase("C")) {
            cTemp = temp-273;
            JOptionPane.showMessageDialog(null, "That temperature is equivalent to "+cTemp+"°C");
        } else if(unitFrom.equalsIgnoreCase("K") && unitTo.equalsIgnoreCase("F")) {
            cTemp = ((temp - 273)*1.8) + 32;
            JOptionPane.showMessageDialog(null, "That temperature is equivalent to "+cTemp+"°F");
        }

    }
    
}
