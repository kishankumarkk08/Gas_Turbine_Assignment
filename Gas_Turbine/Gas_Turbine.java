package Gas_Turbine;

import java.util.*;
import java.io.*;

public class Gas_Turbine {
  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
      while (st == null || !st.hasMoreTokens()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine().trim();
      } catch (Exception e) {
        e.printStackTrace();
      }
      return str;
    }
  }

  static class FastWriter {
    private final BufferedWriter bw;

    public FastWriter() {
      this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public void print(Object object) throws IOException {
      bw.append("" + object);
    }

    public void println(Object object) throws IOException {
      print(object);
      bw.append("\n");
    }

    public void close() throws IOException {
      bw.close();
    }
  }

  public static void main(String[] args) {
    try {
      FastReader in = new FastReader();
      FastWriter out = new FastWriter();
      System.out.println("<------We Consider a Simple Gas Turbine Cycle------>");
      System.out.print("Enter the number of testcases: ");
      int testCases = in.nextInt();
      while (testCases-- > 0) {
        char gammaSymbol = '\u03B3';

        System.out.print("Is your Gas Turbine Cycle Isentropic (Yes/No): ");
        String isIsentropic = in.nextLine();

        if (isIsentropic.equalsIgnoreCase("No")) {
          System.out.print("Enter Compressor Inlet Temperature (T1) in K: ");
          double T1 = in.nextDouble();

          System.out.print("Enter Turbine Inlet Temperature (T3) in K: ");
          double T3 = in.nextDouble();

          System.out.print("Enter the Pressure Ratio (P2/P1) in decimals: ");
          double Pratio = in.nextDouble();

          System.out.print("Enter the value of " + gammaSymbol + " for Compression Process: ");
          double gammaCompression = in.nextDouble();

          System.out.print("Enter the value of Cp for Compression Process (kJ/kgK): ");
          double cp_Compression = in.nextDouble();

          System.out.print("Enter the value of " + gammaSymbol + " for Expansion Process: ");
          double gammaExpansion = in.nextDouble();

          System.out.print("Enter the value of Cp for Expansion Process (kJ/kgK): ");
          double cp_Expansion = in.nextDouble();

          System.out.print("Enter the Compressor Efficiency (in decimals): ");
          double compressorEfficiency = in.nextDouble();

          System.out.print("Enter the Turbine Efficiency (in decimals): ");
          double turbineEfficiency = in.nextDouble();

          // For Compression Process

          double T2s = T1 * Math.pow(Pratio, (gammaCompression - 1) / gammaCompression);
          System.out.println("The Value of T2s: " + T2s + " K");

          double T2 = ((T2s - T1) / compressorEfficiency) + T1;
          System.out.println("The Value of Compressor Outlet Temperature (T2): " + T2 + " K");

          // For Expansion Process

          double T4s = T3 / Math.pow(Pratio, (gammaExpansion - 1) / gammaExpansion);
          System.out.println("The Value of T4s: " + T4s + " K");

          double T4 = turbineEfficiency * (T4s - T3) + T3;
          System.out.println("The Value of Turbine Outlet Temperature (T4): " + T4 + " K");

          double workCompressor = cp_Compression * (T2 - T1);
          System.out.println("Compressor Work: " + workCompressor + " kJ/Kg");

          double workTurbine = cp_Expansion * (T3 - T4);
          System.out.println("Turbine Work: " + workTurbine + " kJ/Kg");

          double nonDimensionalSpecificWork = (Math.abs(workTurbine - workCompressor)) / (1.005 * T1);
          System.out.println("Non Dimensional Specific Work (Cp = 1.005): " + nonDimensionalSpecificWork);

          double heatInput = 1.005 * (T3 - T2);
          System.out.println("Heat Input: " + heatInput + " kJ/kg");

          double cycleEfficiency = ((Math.abs(workTurbine - workCompressor)) / heatInput) * 100;
          System.out.println("The efficiency of the cycle is: " + cycleEfficiency + " %");

        }

        else {
          System.out.print("Enter Compressor Inlet Temperature (T1) in K: ");
          double T1 = in.nextDouble();

          System.out.print("Enter Turbine Inlet Temperature (T3) in K: ");
          double T3 = in.nextDouble();

          System.out.print("Enter the Pressure Ratio (P2/P1) in decimals: ");
          double Pratio = in.nextDouble();

          System.out.print("Enter the value of " + gammaSymbol + ": ");
          double gamma = in.nextDouble();

          System.out.print("Enter the value of Cp (kJ/kgK): ");
          double cp = in.nextDouble();

          double T2 = T1 * Math.pow(Pratio, (gamma - 1) / gamma);
          System.out.println("The Value of T2: " + T2 + " K");

          double T4 = T3 / Math.pow(Pratio, (gamma - 1) / gamma);
          System.out.println("The Value of T4: " + T4 + " K");

          double workCompressor = cp * (T2 - T1);
          System.out.println("Compressor Work: " + workCompressor + " kJ/Kg");

          double workTurbine = cp * (T3 - T4);
          System.out.println("Turbine Work: " + workTurbine + " kJ/Kg");

          double nonDimensionalSpecificWork = (Math.abs(workTurbine - workCompressor)) / (1.005 * T1);
          System.out.println("Non Dimensional Specific Work (Cp = 1.005): " + nonDimensionalSpecificWork);

          double heatInput = 1.005 * (T3 - T2);
          System.out.println("Heat Input: " + heatInput + " kJ/kg");

          double cycleEfficiency = ((Math.abs(workTurbine - workCompressor)) / heatInput) * 100;
          System.out.println("The efficiency of the cycle is: " + cycleEfficiency + " %");

        }
      }
      out.close();
    } catch (Exception e) {
      return;
    }
  }
}