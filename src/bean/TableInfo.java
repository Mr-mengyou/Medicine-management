package bean;

import java.util.List;

public class TableInfo<T> {
	//���ݿ�������
		private int total;
	    public int getTotal() {
			return total;
		}
		public void setTotal(int total) {
			this.total = total;
		}
		public List<T> getRows() {
			return rows;
		}
		public void setRows(List<T> rows) {
			this.rows = rows;
		}
		//��ǰҳ������
		private List<T> rows;


}
