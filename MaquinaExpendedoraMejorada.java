public class MaquinaExpendedoraMejorada {

    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // El tipo de m�quina
    private boolean tipoMaquina;
    // N� m�ximo de billetes de la m�quina
    private int numeroBillete;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int maxBillete, boolean m�quinaConPremio, int precioDelBillete, String origen, String destino) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        tipoMaquina = m�quinaConPremio;
        numeroBillete = maxBillete;       
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if(cantidadIntroducida > 0) {
            balanceClienteActual = balanceClienteActual + cantidadIntroducida;
        }
        else {
            System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
        }        
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        if (numeroBillete>0){
            if(balanceClienteActual >= precioBillete) {
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                numeroBillete = numeroBillete - 1;

                if (tipoMaquina == true) {
                    if(numeroBillete > 0) {
                        System.out.println("##################");
                        System.out.println("# Billete de tren:");
                        System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                        System.out.println("# " + precioBillete + " euros.");
                        System.out.println("##################");
                        System.out.println();

                        System.out.println("##################");
                        System.out.println("# Enhorabuena");
                        System.out.println("# Billete de tren de regalo");
                        System.out.println("##################");
                        System.out.println();
                        numeroBillete = numeroBillete -1;
                    }
                    else {
                        System.out.println("# No hay ticket regalo");  
                    }          
                }
            }        
            else {
                System.out.println("Necesitas introducir " + (precioBillete - balanceClienteActual) + " euros mas!");
            }
        }
        else {
            System.out.println("No hay m�s billetes");
        }
    }

        /**
         * Cancela la operacion de compra del cliente actual y le
         * devuelve al cliente el dinero que ha introducido hasta el momento
         */
        public int cancelarOperacionYDevolverDinero()
        {
            int cantidadDeDineroADevolver;
            cantidadDeDineroADevolver = balanceClienteActual;
            balanceClienteActual = 0;
            return cantidadDeDineroADevolver;
        }

        /**
         * Devuelve todo el dinero tanto el reci�n introducido como el acumulado 
         */
        public int vaciarDineroDeLaMaquina()
        {
            int cantidadDeDineroADevolver;
            cantidadDeDineroADevolver = totalDineroAcumulado + balanceClienteActual;

            if (balanceClienteActual > 0){
                System.out.println ("Error, queda dinero en de la m�quina");
                int dineroVaciado = -1;
            }
            else {
                cantidadDeDineroADevolver = balanceClienteActual + balanceClienteActual;
                balanceClienteActual = 0;
                totalDineroAcumulado = 0;
            }

            return cantidadDeDineroADevolver;
        }
    }
