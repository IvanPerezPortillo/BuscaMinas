
package tema28prg;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * Redefinició de la clase ObjectOuputStream per a que no escriga la capçalera
 *
 */
public class MiObjectOutputStream extends ObjectOutputStream
{
    /** Constructor */
    public MiObjectOutputStream(OutputStream out) throws IOException
    {
        super(out);
    }

    /** Constructor */
    protected MiObjectOutputStream() throws IOException, SecurityException
    {
        super();
    }

    /** Mètode que esciur la capçalera. El redefinim i deixem en blanc */
    protected void writeStreamHeader() throws IOException
    {
    }

}
