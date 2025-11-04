package Sound_Manage;

// Importacion adicionales
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/*
 * @author SAMUEL CASTRO
 */





/**
 * Clase para reproducir sonidos en formato WAV.
 */
public class Sounds_Player {

    /**
     * Reproduce un archivo WAV en segundo plano.
     * @param ruta Ruta del archivo WAV.
     */
    public static void playSound(String ruta) {
        new Thread(() -> {
            try {
                File archivo = new File(ruta);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivo);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
