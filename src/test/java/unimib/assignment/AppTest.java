package unimib.assignment;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest {
    @Test
    public void shouldAnswerWithTrue()
    {
    	Utente daAggiungere = new Utente(4, "Utente Generico", 0);
    	assert(daAggiungere.getIdUtente() == 4);
    	assert(daAggiungere.getNomeUtente().equals("Utente Generico"));
    	assert(daAggiungere.getNumeroAccessi() == 0);
    }
}

