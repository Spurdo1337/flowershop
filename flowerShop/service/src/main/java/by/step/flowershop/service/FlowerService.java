package by.step.flowershop.service;

import by.step.flowershop.mapper.FlowerMapper;
import by.step.flowershop.mapper.dto.FlowerDto;
import by.step.flowershop.model.Flower;
import by.step.flowershop.repository.FlowerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FlowerService implements FlowerAbstractService {

    private FlowerRepository flowerRepository;

    private FlowerMapper flowerMapper;

    @Override
    public void addFlower(FlowerDto flowerDto) {
        Flower flower = flowerMapper.flowerDtoToFlower(flowerDto);
        flowerRepository.save(flower);
    }

    @Override
    public void delete(Long id) {
        flowerRepository.deleteById(id);
    }

    @Override
    public int remainingQuantity(Long id) {
        return flowerRepository.remainingQuantity(id);
    }

    @Override
    public void updateQuantity(Long id, int quantity) {
        flowerRepository.updateQuantity(id, quantity);
    }

    @Override
    public void updatePrice(Long id, double price) {
        flowerRepository.updatePrice(id, price);
    }

    @Override
    public Page<FlowerDto> getAllFlowers(int offset) {
        PageRequest pageRequest = PageRequest.of(offset, 50);
        Page<Flower> flowerPage = flowerRepository.findAll(pageRequest);
        return flowerPage.map(flowerMapper::flowerToFlowerDto);
    }

    @Override
    public List<FlowerDto> findFlowerById(Long id) {
        List<Flower> flowers = flowerRepository.findFlowerById(id);
        return flowers.stream().map(flowerMapper::flowerToFlowerDto).collect(Collectors.toList());
    }

    @Override
    public List<FlowerDto> findFlowerByName(String name) {
        List<Flower> flowers = flowerRepository.findFlowerByName(name);
        return flowers.stream().map(flowerMapper::flowerToFlowerDto).collect(Collectors.toList());
    }

    @Override
    public Page<FlowerDto> findAllByPriceBetweenOrderByPriceAsc(double price1, double price2, int offset) {
        if (offset < 0) {
            throw new IllegalArgumentException("Offset must be a positive value.");
        }
        if (price2 < 0 || price1 < 0) {
            throw new IllegalArgumentException("Price must be a positive value.");
        }
        PageRequest pageRequest = PageRequest.of(offset, 50);
        Page<Flower> flowerPage = flowerRepository.findAllByPriceBetweenOrderByPriceAsc(price1, price2, pageRequest);
        return flowerPage.map(flowerMapper::flowerToFlowerDto);
    }
}
