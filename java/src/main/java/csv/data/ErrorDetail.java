package csv.data;


public class ErrorDetail implements Comparable<ErrorDetail> {
    
    private String domain;

    private String system;

    private String httpCode;

    private String facadeCode;

    private String facadeDescription;

    private String coreCode;

    private String coreDescription;

    private String processFlow;

    private String processStep;

    private String result;

    private String upstreamCode;

    private String upstreamDescription;

    public String getDomain() {
        return domain;
    }

    public String getSystem() {
        return system;
    }

    public String getHttpCode() {
        return httpCode;
    }

    public String getFacadeCode() {
        return facadeCode;
    }

    public String getFacadeDescription() {
        return facadeDescription;
    }

    public String getCoreCode() {
        return coreCode;
    }

    public String getCoreDescription() {
        return coreDescription;
    }

    public String getProcessFlow() {
        return processFlow;
    }

    public String getProcessStep() {
        return processStep;
    }

    public String getResult() {
        return result;
    }

    public String getUpstreamCode() {
        return upstreamCode;
    }

    public String getUpstreamDescription() {
        return upstreamDescription;
    }

    public ErrorDetail(final String domain, final String system, final String httpCode, final String facadeCode,
            final String facadeDescription, final String coreCode, final String coreDescription,
            final String processFlow, final String processStep, final String result, final String upstreamCode,
            final String upstreamDescription) {
        super();
        this.domain = domain;
        this.system = system;
        this.httpCode = httpCode;
        this.facadeCode = facadeCode;
        this.facadeDescription = facadeDescription;
        this.coreCode = coreCode;
        this.coreDescription = coreDescription;
        this.processFlow = processFlow;
        this.processStep = processStep;
        this.result = result;
        this.upstreamCode = upstreamCode;
        this.upstreamDescription = upstreamDescription;
    }

    @Override
    public String toString() {
        return "ErrorDetail [domain=" + domain + ", system=" + system + ", httpCode=" + httpCode + ", facadeCode="
                + facadeCode + ", facadeDescription=" + facadeDescription + ", coreCode=" + coreCode
                + ", coreDescription=" + coreDescription + ", processFlow=" + processFlow + ", processStep="
                + processStep + ", result=" + result + ", upstreamCode=" + upstreamCode + ", upstreamDescription="
                + upstreamDescription + "]";
    }

    public int compareTo(final ErrorDetail o) {
        if (this.domain.compareToIgnoreCase(o.domain) == 0 && this.system.compareToIgnoreCase(o.system) == 0
                && this.httpCode.compareToIgnoreCase(o.httpCode) == 0
                && this.facadeCode.compareToIgnoreCase(o.facadeCode) == 0
                && this.facadeDescription.compareToIgnoreCase(o.facadeDescription) == 0
                && this.coreCode.compareToIgnoreCase(o.coreCode) == 0
                && this.coreDescription.compareToIgnoreCase(o.coreDescription) == 0
                && this.processFlow.compareToIgnoreCase(o.processFlow) == 0
                && this.processStep.compareToIgnoreCase(o.processStep) == 0
                && this.result.compareToIgnoreCase(o.result) == 0
                && this.upstreamCode.compareToIgnoreCase(o.upstreamCode) == 0
                && this.upstreamDescription.compareToIgnoreCase(o.upstreamDescription) == 0) {
            return 0;

        } else if (this.system.compareToIgnoreCase(o.system) == 0) {
            return 1;
        } else {
            return this.system.compareToIgnoreCase(o.system);
        }

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((coreCode == null) ? 0 : coreCode.hashCode());
        result = prime * result + ((coreDescription == null) ? 0 : coreDescription.hashCode());
        result = prime * result + ((domain == null) ? 0 : domain.hashCode());
        result = prime * result + ((facadeCode == null) ? 0 : facadeCode.hashCode());
        result = prime * result + ((facadeDescription == null) ? 0 : facadeDescription.hashCode());
        result = prime * result + ((httpCode == null) ? 0 : httpCode.hashCode());
        result = prime * result + ((processFlow == null) ? 0 : processFlow.hashCode());
        result = prime * result + ((processStep == null) ? 0 : processStep.hashCode());
        result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
        result = prime * result + ((system == null) ? 0 : system.hashCode());
        result = prime * result + ((upstreamCode == null) ? 0 : upstreamCode.hashCode());
        result = prime * result + ((upstreamDescription == null) ? 0 : upstreamDescription.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ErrorDetail other = (ErrorDetail) obj;
        if (coreCode == null) {
            if (other.coreCode != null)
                return false;
        } else if (!coreCode.equals(other.coreCode))
            return false;
        if (coreDescription == null) {
            if (other.coreDescription != null)
                return false;
        } else if (!coreDescription.equals(other.coreDescription))
            return false;
        if (domain == null) {
            if (other.domain != null)
                return false;
        } else if (!domain.equals(other.domain))
            return false;
        if (facadeCode == null) {
            if (other.facadeCode != null)
                return false;
        } else if (!facadeCode.equals(other.facadeCode))
            return false;
        if (facadeDescription == null) {
            if (other.facadeDescription != null)
                return false;
        } else if (!facadeDescription.equals(other.facadeDescription))
            return false;
        if (httpCode == null) {
            if (other.httpCode != null)
                return false;
        } else if (!httpCode.equals(other.httpCode))
            return false;
        if (processFlow == null) {
            if (other.processFlow != null)
                return false;
        } else if (!processFlow.equals(other.processFlow))
            return false;
        if (processStep == null) {
            if (other.processStep != null)
                return false;
        } else if (!processStep.equals(other.processStep))
            return false;
        if (result == null) {
            if (other.result != null)
                return false;
        } else if (!result.equals(other.result))
            return false;
        if (system == null) {
            if (other.system != null)
                return false;
        } else if (!system.equals(other.system))
            return false;
        if (upstreamCode == null) {
            if (other.upstreamCode != null)
                return false;
        } else if (!upstreamCode.equals(other.upstreamCode))
            return false;
        if (upstreamDescription == null) {
            if (other.upstreamDescription != null)
                return false;
        } else if (!upstreamDescription.equals(other.upstreamDescription))
            return false;
        return true;
    }


}
