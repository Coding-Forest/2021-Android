package com.example.typewriter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    String teamMembers = "member 1, member2, member3, member4";
    String teamName = "team name";

    Typewriter TWmembers;
    Typewriter TWteam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TWmembers = findViewById(R.id.TWteamMembers);
        TWteam = findViewById(R.id.TWteamName);

        TypewriterThread membersThread = new TypewriterThread(TWmembers, teamMembers);

        try {
            membersThread.start();
            membersThread.join();
            TypewriterThread teamThread = new TypewriterThread(TWteam, teamName);
            TWqueue.runNext(teamThread);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    class TypewriterThread extends Thread {
        Typewriter tw;
        String text;

        TypewriterThread(Typewriter tw, String text) {
            this.tw = tw;
            this.text = text;
        }

        @Override
        public void run() {
            tw.setText("");
            tw.setCharacterDelay(95);
            tw.animateText(text);
        }
    }

    abstract static class TWqueue implements TWcallback {

        static void runNext(TypewriterThread thread) {
            try {
                thread.start();
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    interface TWcallback {
        static void runNext() {

        };
    }
}
