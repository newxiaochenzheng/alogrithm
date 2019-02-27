package com.test.design.obsever;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LocalBroadcastManager {

    private LocalBroadcastManager() {

    }

    private static LocalBroadcastManager sLocalBroadcastManager;
    private static final Object mLock = new Object();

    public static LocalBroadcastManager getInstance() {
        synchronized (mLock) {
            if (sLocalBroadcastManager == null) {
                sLocalBroadcastManager = new LocalBroadcastManager();
            }
            return sLocalBroadcastManager;
        }
    }

    private class ReceiverRecord {
        public BroadcastReceiver receiver;
        public Intent intent;

        public ReceiverRecord(Intent intent, BroadcastReceiver receiver) {
            this.intent = intent;
            this.receiver = receiver;
        }
    }

    private final HashMap<BroadcastReceiver, List<ReceiverRecord>> mReceivers = new HashMap<>();
    private final HashMap<String, List<ReceiverRecord>> mActions = new HashMap<>();

    public void registerReceiver(BroadcastReceiver receiver, Intent intent) {
        synchronized (mReceivers) {
            ReceiverRecord entry = new ReceiverRecord(intent, receiver);
            List<ReceiverRecord> receiverRecords = mReceivers.computeIfAbsent(receiver,
                    k -> new ArrayList<>(1));
            receiverRecords.add(entry);
            List<ReceiverRecord> entries = mActions.computeIfAbsent(intent.getAction(),
                    k -> new ArrayList<>(1));
            entries.add(entry);
        }
    }

    public void sendBroadcast(Intent intent) {
        synchronized (mReceivers) {
            List<ReceiverRecord> entries = mActions.get(intent.getAction());
            if (entries != null) {
                List<ReceiverRecord> receivers = null;
                for (ReceiverRecord receiverRecord : entries) {
                    if (receivers == null) {
                        receivers = new ArrayList<>();
                    }
                    receivers.add(receiverRecord);
                }
                if (receivers != null) {
                    for (ReceiverRecord receiverRecord : receivers) {
                        receiverRecord.receiver.onReceive(intent);
                    }
                }
            }
        }
    }

}