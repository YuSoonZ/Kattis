def fimmtudagstilbod() -> None:
    y = int(input())

    start_price = 1000
    start_year = 2020
    increase = 100

    if y < 2021:
        print(start_price)
    else:
        price_increase = (y - start_year) * increase
        print(price_increase + start_price)

fimmtudagstilbod()