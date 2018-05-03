package com.iumsocius.zizi.testfirst;

import com.iumsocius.zizi.testfirst.data.Coin;
import com.iumsocius.zizi.testfirst.data.User;
import com.iumsocius.zizi.testfirst.data.Wallet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by zizi on 18/04/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainUnitTest {

    @Mock
    Wallet wallet1;

    Coin coin1;
    Coin coin2;

    @Before
    public void setCoins() {
        coin1 = new Coin();
        coin1.setCurrency("btc");
        coin1.setLast(1000);

        coin2 = new Coin();
        coin2.setCurrency("qtum");
        coin2.setLast(3000);
    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test(expected=NullPointerException.class)
    public void getNullObject() {
        User user = new User();
        user.getWallets().get(0).setCoin(new Coin());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testIAE() {
        throw new IllegalArgumentException();
    }

    @Test(timeout=1000)
    public void calcurateEstimatedBalance() {
        User user = new User();

        Wallet wallet2 = mock(Wallet.class);

        user.addWallets(wallet1);
        user.addWallets(wallet2);

        when(wallet1.getCoin()).thenReturn(coin1);
        when(wallet2.getCoin()).thenReturn(coin2);
        when(wallet1.getAmount()).thenReturn(2);
        when(wallet2.getAmount()).thenReturn(4);

        assertEquals(2, user.getWallets().size());

        user.getBalance();

        verify(wallet1, timeout(100)).getCoin();
        verify(wallet1).getAmount();
        assertEquals(14000, user.getBalance());
    }
}
