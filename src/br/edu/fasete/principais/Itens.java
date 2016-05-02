package br.edu.fasete.principais;


	public class Itens {
		private int codItens;
		private int codRoupa;
		private int codPessoa;
		static int numItem = 1;
		
		public Itens(){}
		
		@SuppressWarnings("unused")
		private Itens(int codItens, int codRoupa, int numItem, int codPessoa) {
			super();
			this.codItens = codItens;
			this.codRoupa = codRoupa;
			this.setCodPessoa(codPessoa);
		}
		public int getCodItens() {
			return codItens;
		}
		public void setCodItens(int codItens) {
			this.codItens = codItens;
		}
		public int getCodRoupa() {
			return codRoupa;
		}
		public void setCodRoupa(int codRoupa) {
			this.codRoupa = codRoupa;
		}
		public int getNumItem() {
			return numItem;
		}
		@SuppressWarnings("static-access")
		public void setNumItem(int numItem) {
			this.numItem = numItem;
		}
		public int getCodPessoa() {
			return codPessoa;
		}
		public void setCodPessoa(int codPessoa) {
			this.codPessoa = codPessoa;
		}
	}


