package br.com.brpartners.technical.evaluation.service;

import javax.enterprise.context.RequestScoped;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
@RequestScoped
public class BankAccountService {


	/*
	TODO
	Metodo que realiza calculo de digito confome um numero de conta infomado.
	Analise as regra implementadas e postoriormente realize uma refatoração no mesmo deixando-o mais conciso e menos verboso,
	utilize seus conhecimentos com Lambdas, Streams e Functions
	 */
	public String getAccountWithDigit(String accountNumber) {

		String accountNumberformater = null;
		log.info("Conta informada: " + accountNumber);

		if (accountNumber != null) {
			if (accountNumber.matches("[0-9]+")) {
				int digito;
				String accountNumberDv = StringUtils.leftPad(accountNumber.trim(),7, "0");
				accountNumberDv = accountNumberDv.substring(0, 2) + "00476" + accountNumberDv.substring(2);

				int somatoria = 0;
				int[] pesos = {5,4,3,2,9,8,7,6,5,4,3,2};

				for (int i=0; i <= accountNumberDv.length()-1; i++) {
					somatoria += Integer.parseInt(String.valueOf(accountNumberDv.charAt(i))) * pesos[i];
				}
				int resto = somatoria%11;

				if(resto == 0 || resto == 1) {
					digito = 0;
				} else {
					digito = (11 - resto);
				}
				accountNumberformater = StringUtils.leftPad(accountNumber,9, "0").concat("-" + digito);
				log.info("Conta com dígito: "+ accountNumberformater);
				return accountNumberformater;
			}else {
				throw new RuntimeException("Número de conta inválido");
			}
		} else {
			throw new RuntimeException("Número de conta inválido");
		}
	}
}
