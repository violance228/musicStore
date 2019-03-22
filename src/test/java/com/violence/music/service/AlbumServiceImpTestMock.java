package com.violence.music.service;

import com.violence.music.entity.Album;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * created by user violence
 * created on 22.03.2019
 * class created for project musicStore
 */

public class AlbumServiceImpTestMock {
    @Mock
    AlbumService albumService;
    @InjectMocks
    AlbumServiceImpl albumServiceMock;

    @Before
    public void init() {
        initMocks(this);
        albumServiceMock = new AlbumServiceImpl();
    }

    @Test
    public void getAll() {
        when(albumService.getAll()).thenReturn(setAlbumServiceGetAll());
        Assert.assertNotNull(albumService.getAll());
    }

    @Test
    public void getAllShouldReturnNotNull() {
        Assert.assertNotNull(albumService.getAll());
    }

    @Test
    public void getAllShouldReturnThrow() {
        when(albumService.getAll()).thenThrow(new NoSuchElementException());
        try {
            albumService.getAll();
            Assert.fail();
        } catch (NoSuchElementException e) {
            Assert.assertNotNull(e);
        }
    }

    private List<Album> setAlbumServiceGetAll() {
        List<Album> albums = new LinkedList<>();
        Album album = new Album();
        album.setName("OneMoreLight");
        album.setType("LP");
        album.setYear(2017);
        Album album1 = new Album();
        album1.setName("symphonyofDestructuion");
        album1.setType("Megadeth");
        album1.setYear(1980);
        albums.add(album);
        albums.add(album1);
        return albums;
    }
}
//public class RatesUtillServiceImplTest {
//    @Mock
//    private PercentageRateService percentageRateService;
//    @InjectMocks
//    private RatesUtillServiceImpl ratesUtillService;
//    private PercentageRate percentageRate;
//    private GoodsServices goodsServices;
//
//
//    @Before
//    public void init(){
//        initMocks(this);
//        ratesUtillService = new RatesUtillServiceImpl(goodsServices, percentageRateService);
//    }
//
//    @Test
//    public void percentRatePriceToPriceFrom(){
//        Mockito.when(percentageRateService.findAll()).thenReturn(createRatesUtillList());
////        Assert.assertNotNull(ratesUtillService.getPercentRate(100F));
//    }
//
//    private List<PercentageRate> createRatesUtillList(){
//        List<PercentageRate> rates = new ArrayList<>();
//        rates.add(createPercentageRate(50F, 100F, 15F));
//        rates.add(createPercentageRate(100F, 200F, 14F));
//        rates.add(createPercentageRate(200F, 300F, 13F));
//        return rates;
//    }
//
//    private PercentageRate createPercentageRate(Float priceFrom, Float priceTo, Float percentageOfMarkup){
//        PercentageRate percentageRate = new PercentageRate();
//        percentageRate.setPriceTo(priceTo);
//        percentageRate.setPriceFrom(priceFrom);
//        percentageRate.setPercentageOfMarkup(percentageOfMarkup);
//        return percentageRate;
//    }
//}