package com.vds.huylq33.service;

import com.vds.huylq33.model.Person;
import com.vds.huylq33.model.Wallet;

public interface WalletService {
    Wallet createEmptyWallet();
    Wallet createNewWalletAndAttachToPerson(Person person);
    Wallet createNewWalletAndAttachToPerson(int personId);
}
